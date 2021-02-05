package com.xmmems.task.controller;

import com.xmmems.dto.PageResult;
import com.xmmems.service.RepositoryService;
import com.xmmems.task.domain.Sendnotice;
import com.xmmems.task.domain.Tasktemplate;
import com.xmmems.task.service.SendnoticeService;
import com.xmmems.task.service.TasktemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2021.01.20 10:58
 */
@RestController
public class SendnoticeController {

    @Autowired
    private SendnoticeService sendnoticeService;

    @Autowired
    private TasktemplateService tasktemplateService;

    @Autowired
    private RepositoryService repositoryService;

    /**
     * 添加模板
     *
     * @return
     */
    @PostMapping("/task/insertSelective")
    public ResponseEntity<Void> insertSelective(
            @RequestParam("taskName") String taskName,
            @RequestParam("title") String title,
            @RequestParam("content") String content, @RequestParam("sendUser") String sendUser) {

        tasktemplateService.insertSelective(taskName, title, content, sendUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/task/deleteByTaskName")
    public ResponseEntity<Void> deleteByTaskName(@RequestParam("taskName") String taskName) {

        tasktemplateService.deleteByTaskName(taskName);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/task/updateByTasktemplate")
    public ResponseEntity<Void> updateByTasktemplate(
            @RequestParam("taskName") String taskName,
            @RequestParam("title") String title,
            @RequestParam("content") String content, @RequestParam("sendUser") String sendUser) {

        tasktemplateService.updateByTasktemplate(taskName, title, content, sendUser);
        return ResponseEntity.ok().build();
    }

    /**
     * 查询模板
     *
     * @param limit
     * @param page
     * @return
     */
    @GetMapping("/task/selectByExample")
    public ResponseEntity<PageResult<Tasktemplate>> selectByExample(
            @RequestParam(value = "limit") Integer limit, @RequestParam(value = "page") Integer page) {

        return ResponseEntity.ok(tasktemplateService.selectByExample(limit, page));
    }

    /**
     * 发送任务
     */
    @PostMapping("task/sendTask")
    public Integer sendTask(
            @RequestParam("siteId") Integer siteId,
            @RequestParam("siteName") String siteName,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("sendAccountName") String sendAccountName,
            @RequestParam("receiveAccountIds") List<Integer> receiveAccountIds) {

        Sendnotice sendnotice = new Sendnotice();
        sendnotice.setSiteId(siteId);
        sendnotice.setSendAccountName(sendAccountName);
        sendnotice.setTitle(title);
        sendnotice.setContent(content);
        sendnotice.setSiteName(siteName);
        return sendnoticeService.sendTask(sendnotice, receiveAccountIds);
    }

    /**
     * 查找任务
     *
     * @param limit
     * @param page
     * @param createTimeStart
     * @param createTimeEnd
     * @param sendTimeStart
     * @param sendTimeEnd
     * @param receiptTimeStart
     * @param receiptTimeEnd
     * @param isReceipt
     * @param readType
     * @return
     */
    @GetMapping("task/findTask")
    public PageResult<Sendnotice> findTask(
            @RequestParam(value = "limit") Integer limit,
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "createTimeStart", required = false) String createTimeStart,
            @RequestParam(value = "createTimeEnd", required = false) String createTimeEnd,
            @RequestParam(value = "sendTimeStart", required = false) String sendTimeStart,
            @RequestParam(value = "sendTimeEnd", required = false) String sendTimeEnd,
            @RequestParam(value = "receiptTimeStart", required = false) String receiptTimeStart,
            @RequestParam(value = "receiptTimeEnd", required = false) String receiptTimeEnd,
            @RequestParam(value = "isReceipt", required = false) Boolean isReceipt,
            @RequestParam(value = "readType", required = false) String readType) {
        return sendnoticeService.findTask(limit, page, createTimeStart, createTimeEnd, sendTimeStart, sendTimeEnd, receiptTimeStart, receiptTimeEnd, isReceipt, readType);
    }

    /**
     * 接收任务
     *
     * @param readType
     * @param noticeId
     * @return
     */
    @PostMapping("task/updateTask")
    public Integer updateTask(
            @RequestParam(value = "readType") String readType, @RequestParam("noticeId") Integer noticeId) {

        return sendnoticeService.updateTask(readType, noticeId);
    }

    /**
     * 上传回执
     *
     * @param noticeId
     * @param file
     * @return
     */
    @PostMapping("task/updateUrl")
    public Integer updateUrl(
            @RequestParam(value = "noticeId", required = false) Integer noticeId,
            @RequestParam("file") MultipartFile file, @RequestParam(value = "id", required = false) Integer id) {

        if (noticeId != null) {
            return sendnoticeService.updateUrl(noticeId, file);
        }
        if (id != null) {
            return repositoryService.updateUrl(id, file);
        }
        return null;
    }

    /**
     * 填写意见
     *
     * @param opinion
     * @param noticeId
     * @return
     */
    @PostMapping("task/updateOpinion")
    public Integer updateOpinion(
            @RequestParam(value = "opinion") String opinion, @RequestParam("noticeId") Integer noticeId) {

        return sendnoticeService.updateOpinion(opinion, noticeId);
    }

    @PostMapping("task/delTask")
    public Integer delTask(@RequestParam("noticeId") Integer noticeId) {

        return sendnoticeService.delTask(noticeId);
    }

}
