package com.xmmems.task.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.auth.domain.UserHolder;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.domain.OperationPerson;
import com.xmmems.dto.AccountDTO;
import com.xmmems.dto.PageResult;
import com.xmmems.mapper.AccountMapper;
import com.xmmems.mapper.CostMapper;
import com.xmmems.mapper.SendnoticeMapper;
import com.xmmems.material.domain.Cost;
import com.xmmems.service.UploadService;
import com.xmmems.service.maintenance.OperationPersonSerice;
import com.xmmems.service.system.AccountService;
import com.xmmems.task.domain.Sendnotice;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2021.01.20 10:58
 */
@Service
@Transactional
public class SendnoticeService {

    @Autowired
    private SendnoticeMapper sendnoticeMapper;
    @Autowired
    private UploadService uploadService;
    @Autowired
    private AccountService accountService;

    @Autowired
    private CostMapper costMapper;

    public Integer save(Sendnotice sendnotice) {
        sendnotice.setCreateTime(new Date());
        sendnoticeMapper.insertSelective(sendnotice);
        return sendnotice.getNoticeId();
    }

    public PageResult<Sendnotice> findTask(Integer limit, Integer page, String createTimeStart, String createTimeEnd, String sendTimeStart, String sendTimeEnd, String receiptTimeStart, String receiptTimeEnd, Boolean isReceipt, String readType) {
        String end = " 23:59:59";
        //封装分页信息
        PageHelper.startPage(page, limit);
        Example example = new Example(Sendnotice.class);
        Example.Criteria criteria = example.createCriteria();
        System.out.println(UserHolder.loginId());
        criteria.andEqualTo("receiveAccountId", UserHolder.loginId());
        criteria.andEqualTo("sendAccountId", UserHolder.loginId());
        if (StringUtils.isNotBlank(createTimeStart)) {
            criteria.andGreaterThanOrEqualTo("createTime", createTimeStart);
        }
        if (StringUtils.isNotBlank(createTimeEnd)) {
            criteria.andLessThanOrEqualTo("createTime", createTimeEnd + end);
        }
        if (StringUtils.isNotBlank(sendTimeStart)) {
            criteria.andGreaterThanOrEqualTo("sendTime", sendTimeStart);
        }
        if (StringUtils.isNotBlank(sendTimeEnd)) {
            criteria.andLessThanOrEqualTo("sendTime", sendTimeEnd + end);
        }
        if (StringUtils.isNotBlank(receiptTimeStart)) {
            criteria.andGreaterThanOrEqualTo("receiptTime", receiptTimeStart);
        }
        if (StringUtils.isNotBlank(receiptTimeEnd)) {
            criteria.andLessThanOrEqualTo("receiptTime", receiptTimeEnd + end);
        }
        if (isReceipt != null) {
            if (isReceipt) {
                criteria.andIsNotNull("receiptTime");
            } else {
                criteria.andIsNull("receiptTime");
            }
        }
        if (StringUtils.isNotBlank(readType)) {
            criteria.andEqualTo("readType", readType);
        }
        List<Sendnotice> sendnotices = sendnoticeMapper.selectByExample(example);
        PageInfo<Sendnotice> pageInfo = new PageInfo<>(sendnotices);
        return new PageResult<>(pageInfo.getPageSize(), page, pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
    }

    public Integer sendTask(Sendnotice sendnotice, List<Integer> receiveAccountIds) {
        PageResult<AccountDTO> accountDTO = accountService.pageQuery(30,1,null);

        Date createTime = new Date();
        for (AccountDTO row : accountDTO.getRows()) {
            if (row.getNickName().equals(sendnotice.getSendAccountName())) {
                sendnotice.setSendAccountId(row.getId());
                break;
            }
        }

        sendnotice.setCreateTime(createTime);
        sendnotice.setSendTime(createTime);
        int count = 0;
        for (Integer accountId : receiveAccountIds) {
            sendnotice.setReceiveAccountId(accountId);
            for (AccountDTO row : accountDTO.getRows()) {
                if (row.getId().equals(accountId)) {
                    sendnotice.setReceiveAccountName(row.getNickName());
                    break;
                }
            }
            sendnotice.setNoticeId(null);
            int i = sendnoticeMapper.insertSelective(sendnotice);
            count += i;
        }
        return count;
    }

    public Integer updateTask(String readType, Integer noticeId) {

        Sendnotice sendnotice = new Sendnotice();
        sendnotice.setNoticeId(noticeId);
        sendnotice.setReadType(readType);
        //更新通知状态
        return sendnoticeMapper.updateByPrimaryKeySelective(sendnotice);
    }

    public Integer updateUrl(Integer noticeId, MultipartFile file,String opinion) {

        Sendnotice sendnotice = new Sendnotice();
        sendnotice.setNoticeId(noticeId);
        String url = uploadService.file(file);
        sendnotice.setAnnexUrl(url);
        sendnotice.setReceiptTime(new Date());
        sendnotice.setReadType("已回执");
        sendnotice.setOpinion(opinion);
        int result=sendnoticeMapper.updateByPrimaryKeySelective(sendnotice);
//        Sendnotice newsendnotice=  sendnoticeMapper.findBynoticeId(noticeId);
        List<Cost> costList=costMapper.findCost();
        List<Cost> costListAll= costMapper.findCostAll();
        double one=500;
        double two=100;
        costList.forEach(temp -> {
            Cost cost=new Cost();
            costListAll.forEach(tempAll -> {
                if(!temp.getNoticeId().equals(tempAll.getNoticeId())){
                    cost.setNoticeId(temp.getNoticeId());
                    cost.setReceiveAccountId(temp.getReceiveAccountId());
                    cost.setReceiveAccountName(temp.getReceiveAccountName());
                    cost.setReceiptTime(temp.getReceiptTime());
                    cost.setCounts(temp.getCounts());
                    for(int i=1;i<=temp.getCounts();i++) {
                        if (i == 1) {
                            cost.setPrice(one);
                        } else{
                            cost.setPrice(cost.getPrice() + two);
                        }
                    }
                }

            });
            //添加到成本分析表里面
            costMapper.insertSelective(cost);
        });

        try {
            return result;
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.UPDATE_ERROR);
        }

    }

    public Integer updateOpinion(String Opinion, Integer noticeId) {

        Sendnotice sendnotice = new Sendnotice();
        sendnotice.setNoticeId(noticeId);
        sendnotice.setOpinion(Opinion);
        //更新通知状态
        try {
            return sendnoticeMapper.updateByPrimaryKeySelective(sendnotice);
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.UPDATE_ERROR);
        }
    }

    public Integer delTask(Integer noticeId) {
        try {
           return sendnoticeMapper.deleteByPrimaryKey(noticeId);
        } catch (Exception e) {
            throw new XMException(ExceptionEnum.DELETE_ERROR);
        }
    }
}
