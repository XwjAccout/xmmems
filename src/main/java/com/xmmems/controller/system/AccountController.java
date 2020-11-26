package com.xmmems.controller.system;

import com.xmmems.domain.account.Account;
import com.xmmems.dto.AccountDTO;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.system.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService accountService;


    /**
     * 分页查询账户用户
     *
     * @param limit
     * @param page
     * @param userName
     * @return
     */
    @GetMapping("/paginate")
    @SystemControllerLog(descrption = "分页查询账户列表", actionType = "4")
    public ResponseEntity<PageResult<AccountDTO>> sitePageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                @RequestParam(value = "userName", required = false) String userName) {
        PageResult<AccountDTO> pageResult= accountService.pageQuery(limit, page, userName);
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 根据id查找账户用户
     *
     * @param id
     * @return
     */
    @GetMapping("/findById")
    @SystemControllerLog(descrption = "根据id查询账户", actionType = "4")
    public ResponseEntity<AccountDTO> findById(@RequestParam(value = "id") Integer id) {
        AccountDTO account = accountService.findById(id);
        return ResponseEntity.ok(account);
    }


    /**
     * 添加账户用户
     *
     * @param account
     * @return
     */
    @PostMapping("/save")
    @SystemControllerLog(descrption = "添加账户", actionType = "1")
    public ResponseEntity<Void> save(@RequestBody Account account) {
        accountService.save(account);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 更新账户用户
     *
     * @param account
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    @SystemControllerLog(descrption = "修改账户", actionType = "2")
    public ResponseEntity<Void> update(@RequestBody Account account) {
        accountService.update(account);
        return ResponseEntity.ok().build();
    }

    /**
     * 更新账户用户
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/updatePassword",method = RequestMethod.GET)
    public ResponseEntity<String> updatePassword( String password,String userName) {
       String result= accountService.updatePassword(password,userName);
        return ResponseEntity.ok(result);
    }


    /**
     * 根据id删除账户用户
     *
     * @param id
     * @return
     */
    @PostMapping("/delete")
    @SystemControllerLog(descrption = "根据id删除账户", actionType = "3")
    public ResponseEntity<Void> delete(@RequestParam(value = "id") Integer id) {
        accountService.delete(id);
        return ResponseEntity.ok().build();
    }

    /**
     * 锁定操作  -1 锁定并下线  1 解锁
     *
     * @param id
     * @param status
     * @return
     */
    @PostMapping("/lock")
    @SystemControllerLog(descrption = "锁定账户", actionType = "2")
    public ResponseEntity<Void> lock(@RequestParam(value = "id") Integer id,
                                     @RequestParam(value = "status") Integer status) {
        accountService.lock(id, status);
        return ResponseEntity.ok().build();
    }


    /**
     * 根据账户id，角色id给账户添加角色
     * @param accountId
     * @param roleId
     * @return
     */
    @PostMapping("/saveRole")
    @SystemControllerLog(descrption = "给账户添加角色", actionType = "1")
    public ResponseEntity<Void> saveRole(@RequestParam(value = "accountId") Integer accountId,
                                           @RequestParam(value = "roleId") Integer roleId) {
        accountService.saveRole(accountId, roleId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 根据账户id，角色id给账户删除角色
     * @param accountId
     * @param roleId
     * @return
     */
    @PostMapping("/deleteRole")
    @SystemControllerLog(descrption = "给账户删除角色", actionType = "3")
    public ResponseEntity<Void> deleteRole(@RequestParam(value = "accountId") Integer accountId,
                                           @RequestParam(value = "roleId") Integer roleId) {
        accountService.deleteRole(accountId, roleId);
        return ResponseEntity.ok().build();
    }

    /**
     * 根据账户id，站点id给账户添加站点
     * @param accountId
     * @param siteId
     * @return
     */
    @PostMapping("/saveSite")
    @SystemControllerLog(descrption = "给账户添加站点", actionType = "1")
    public ResponseEntity<Void> saveSite(@RequestParam(value = "accountId") Integer accountId,
                                         @RequestParam(value = "siteId") Integer siteId) {
        accountService.saveSite(accountId, siteId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 根据账户id，站点id给账户删除站点
     * @param accountId
     * @param siteId
     * @return
     */
    @PostMapping("/deleteSite")
    @SystemControllerLog(descrption = "给账户删除站点", actionType = "3")
    public ResponseEntity<Void> deleteSite(@RequestParam(value = "accountId") Integer accountId,
                                           @RequestParam(value = "siteId") Integer siteId) {
        accountService.deleteSite(accountId, siteId);
        return ResponseEntity.ok().build();
    }

    /**
     * 设置中心站点 如果没有中心站点则siteId设置为0
     * @param accountId
     * @param siteId
     * @return
     */
    @PostMapping("/updateCenterSite")
    @SystemControllerLog(descrption = "给账户设置中心站点", actionType = "2")
    public ResponseEntity<Void> updateCenterSite(@RequestParam(value = "accountId") Integer accountId,
                                           @RequestParam(value = "siteId") Integer siteId) {
        accountService.updateCenterSite(accountId, siteId);
        return ResponseEntity.ok().build();
    }

}
