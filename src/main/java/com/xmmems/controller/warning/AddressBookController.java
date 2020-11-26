package com.xmmems.controller.warning;

import com.xmmems.domain.env.EnvAddressBook;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.warning.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/addressBook")
public class AddressBookController {
    @Autowired
    AddressBookService addressBookService;
    /**
     * 分页查询角色
     * @param limit
     * @param page
     * @param name
     * @return
     */
    @GetMapping("/paginate")
    @SystemControllerLog(descrption = "分页查询通讯录", actionType = "4")
    public ResponseEntity<PageResult<EnvAddressBook>> sitePageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                    @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                    @RequestParam(value = "name", required = false) String name){
        PageResult<EnvAddressBook> pageResult = addressBookService.pageQuery(limit, page, name);
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 根据id查找角色
     * @param id
     * @return
     */
    @GetMapping("/findById")
    @SystemControllerLog(descrption = "根据id查询通讯录", actionType = "4")
    public ResponseEntity<EnvAddressBook> findById(@RequestParam(value = "id") Integer id){
        EnvAddressBook envAddressBook = addressBookService.findById(id);
        return ResponseEntity.ok(envAddressBook);
    }

    /**
     * 添加角色
     * @param envAddressBook
     * @return
     */
    @PostMapping("/save")
    @SystemControllerLog(descrption = "添加通讯录", actionType = "1")
    public ResponseEntity<Void> save(@RequestBody  EnvAddressBook envAddressBook){
        addressBookService.save(envAddressBook);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 更新角色
     * @param envAddressBook
     * @return
     */
    @PostMapping("/update")
    @SystemControllerLog(descrption = "修改通讯录", actionType = "2")
    public ResponseEntity<Void> update(@RequestBody EnvAddressBook envAddressBook){
        addressBookService.update(envAddressBook);
        return ResponseEntity.ok().build();
    }

    /**
     * 根据id删除角色
     * @param id
     * @return
     */
    @PostMapping("/delete")
    @SystemControllerLog(descrption = "根据id删除通讯录", actionType = "3")
    public ResponseEntity<Void> delete(@RequestParam(value = "id") Integer id){
        addressBookService.delete(id);
        return ResponseEntity.ok().build();
    }


}
