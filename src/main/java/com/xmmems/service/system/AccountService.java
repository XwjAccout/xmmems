package com.xmmems.service.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmmems.common.auth.domain.UserHolder;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.common.utils.BeanHelper;
import com.xmmems.common.utils.CustomUtils;
import com.xmmems.common.utils.XmRedis;
import com.xmmems.common.utils.XmRedisConstans;
import com.xmmems.domain.account.Account;
import com.xmmems.domain.account.AccountExample;
import com.xmmems.domain.base.BaseSite;
import com.xmmems.dto.AccountDTO;
import com.xmmems.dto.PageResult;
import com.xmmems.dto.RoleDTO;
import com.xmmems.dto.UserDTO;
import com.xmmems.mapper.AccountMapper;
import com.xmmems.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private RoleService roleService;

    /**
     * 根据用户名查找用户信息
     */
    public UserDTO findAccountByUsername(String username) {
        Account account = accountMapper.findByName(username);
        if (account == null) {
            log.error("用户名{}不存在",username);
            throw new XMException(ExceptionEnum.ACCOUNT_NOT_FOUND);
        }
        if (-1==account.getStatus()) {
            String err = "用户"+username+"已经被管理员锁定,请联系管理员解锁";
            log.error(err);
            throw new XMException(500,err);
        }
        UserDTO userDTO = BeanHelper.copyProperties(account, UserDTO.class);
        userDTO.setUsername(account.getUserName());

        //查询角色信息
        List<RoleDTO> list = roleService.findRoleByAccountId(account.getId());
        userDTO.setRoles(list);

        return userDTO;
    }
    //
    public BaseSite findBycenterSiteId() {
        return accountMapper.findBycenterSiteId(UserHolder.loginId());
    }

    public PageResult<AccountDTO> pageQuery(Integer limit, Integer page, String userName) {
//        try {
            //封装分页信息
            PageHelper.startPage(page, limit);
            //封装查询条件
            AccountExample example = new AccountExample();
            AccountExample.Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(userName)) {
                criteria.andUserNameLike(CustomUtils.likeValue(userName));
            }
            List<Account> accounts = accountMapper.selectByExample(example);
            PageInfo<Account> info = new PageInfo<>(accounts);
            if (CollectionUtils.isEmpty(accounts)) {
                throw new XMException(ExceptionEnum.ACCOUNT_NOT_FOUND);
            }
            List<AccountDTO> dtos = BeanHelper.copyWithCollection(accounts, AccountDTO.class);

            //封装自定义的分页对象
            //因为中间经过处理，所以分页插件总数需要重新设置
            return new PageResult<>(info.getPageSize(), page, info.getTotal(), info.getPages(), dtos);
//        } catch (Exception e) {
//            throw new XMException(ExceptionEnum.ACCOUNT_NOT_FOUND);
//        }
    }

    @Autowired
    private BaseService baseService;

    public AccountDTO findById(Integer id,String siteType) {
        Account account = accountMapper.selectByPrimaryKey(id);
        if (account == null) {
            throw new XMException(ExceptionEnum.ACCOUNT_NOT_FOUND);
        }
        AccountDTO accountDTO = BeanHelper.copyProperties(account, AccountDTO.class);

        //添加角色信息
        List<RoleDTO> dtos = roleService.findRoleByAccountId(id);
        accountDTO.setRoleDTOS(dtos);
        //添加站点信息
        List<Map<String, Object>> mapList = baseService.findAccountId(id, siteType);
        accountDTO.setSites(mapList);


        return accountDTO;
    }

    public void save(Account account) {
        account.setSalt("1");
        account.setCreateAt(new Date());
        account.setStatus(1);
        //密码加密
        BCryptPasswordEncoder bp = new BCryptPasswordEncoder();
        String encode = bp.encode(account.getPassword());
        account.setPassword(encode);

        int i = accountMapper.insertSelective(account);
        if (i < 1) {
            throw new XMException(ExceptionEnum.INSERT_OPERATION_FAIL);
        }
    }

    public void update(Account account) {
        //密码加密
        BCryptPasswordEncoder bp = new BCryptPasswordEncoder();
        String encode = bp.encode(account.getPassword());
        account.setPassword(encode);

        int i = accountMapper.updateByPrimaryKeySelective(account);
        if (i < 1) {
            throw new XMException(ExceptionEnum.UPDATE_OPERATION_FAIL);
        }
    }
    public String updatePassword(String password,String userName) {
        //密码加密
        BCryptPasswordEncoder bp = new BCryptPasswordEncoder();
        password= bp.encode(password);
        int i = accountMapper.updatePassword(password,userName,UserHolder.loginId());
        if (i < 1) {
            return "修改密码失败";
//            throw new XMException(ExceptionEnum.UPDATE_OPERATION_FAIL);
        }else{
            return "修改密码成功";
        }
    }
    public void delete(Integer id) {
        if (UserHolder.loginId().equals(id)) {
            throw new XMException(500, "不能删除自己的账号");
        }
        int i = accountMapper.deleteByPrimaryKey(id);
        if (i < 1) {
            throw new XMException(ExceptionEnum.DELETE_OPERATION_FAIL);
        }
    }

    public void lock(Integer id, Integer status) {
        if (status == -1 && UserHolder.loginId().equals(id)) {
            throw new XMException(500, "不能锁定自己的账号");
        }
        if (id == 1) {
            throw new XMException(500, "不能锁定超级管理员的账号");
        }

        Account record = new Account();
        record.setId(id);
        record.setStatus(status);

        int i = accountMapper.updateByPrimaryKeySelective(record);
        if (i < 1) {
            throw new XMException(ExceptionEnum.UPDATE_OPERATION_FAIL);
        }
    }

    public void saveRole(Integer accountId, Integer roleId) {
        //中间表
        int i = accountMapper.insertAccountIdAndRoleId(accountId, roleId);

        if (i < 1) {
            throw new XMException(ExceptionEnum.INSERT_OPERATION_FAIL);
        }
    }

    public void deleteRole(Integer accountId, Integer roleId) {
        int i = accountMapper.deleteAccountIdAndRoleId(accountId, roleId);
        if (i < 1) {
            throw new XMException(ExceptionEnum.DELETE_OPERATION_FAIL);
        }
    }

    public void saveSite(Integer accountId, Integer siteId) {
        int i = accountMapper.insertAccountIdAndSiteId(accountId, siteId);
        XmRedis.remove(XmRedisConstans.common_allItems_+UserHolder.loginId());
        if (i < 1) {
            throw new XMException(ExceptionEnum.INSERT_OPERATION_FAIL);
        }
    }

    public void deleteSite(Integer accountId, Integer siteId) {
        int i = accountMapper.deleteAccountIdAndSiteId(accountId, siteId);
        if (i < 1) {
            throw new XMException(ExceptionEnum.DELETE_OPERATION_FAIL);
        }
    }

    public void updateCenterSite(Integer accountId, Integer siteId) {
        Account record = new Account();
        record.setId(accountId);
        record.setCenterSiteId(siteId);
        int i = accountMapper.updateByPrimaryKeySelective(record);
        if (i < 1) {
            throw new XMException(ExceptionEnum.UPDATE_OPERATION_FAIL);
        }
    }

    public int selectState(Integer id) {
        Account account = accountMapper.selectById(id);
        if(account!=null) {
            return account.getStatus();
        }
        return -1;
    }
}
