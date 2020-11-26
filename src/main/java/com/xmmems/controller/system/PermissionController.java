package com.xmmems.controller.system;

import com.xmmems.domain.role.Permission;
import com.xmmems.dto.PageResult;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.system.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    /**
     * 分页查询权限
     * @param limit
     * @param page
     * @return
     */
    //http://localhost:8089/xmmems/sys/permission/paginate?limit=10&page=1
    @GetMapping("/paginate")
    @SystemControllerLog(descrption = "分页查询权限列表", actionType = "4")
    public ResponseEntity<PageResult<Permission>> sitePageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                              @RequestParam(value = "page", defaultValue = "1") Integer page){
        PageResult<Permission> pageResult  = permissionService.pageQuery(limit, page);
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 根据id查找权限
     * @param id
     * @return
     */
    @GetMapping("/findById")
    @SystemControllerLog(descrption = "根据id查询权限", actionType = "4")
    public ResponseEntity<Permission> findById(@RequestParam(value = "id") Integer id){
        Permission permission = permissionService.findById(id);
        return ResponseEntity.ok(permission);
    }


    /**
     * 添加权限
     * @param permission
     * @return
     */
    @PostMapping("/save")
    @SystemControllerLog(descrption = "添加权限", actionType = "1")
    public ResponseEntity<Void> save(@RequestBody Permission permission){
        permissionService.save(permission);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 更新权限
     * @param permission
     * @return
     */
    @PostMapping("/update")
    @SystemControllerLog(descrption = "修改权限", actionType = "2")
    public ResponseEntity<Void> update(@RequestBody Permission permission){
        permissionService.update(permission);
        return ResponseEntity.ok().build();
    }

    /**
     * 根据id删除权限
     * @param id
     * @return
     */
    @PostMapping("/delete")
    @SystemControllerLog(descrption = "根据id删除权限", actionType = "3")
    public ResponseEntity<Void> delete(@RequestParam(value = "id") Integer id){
        permissionService.delete(id);
        return ResponseEntity.ok().build();
    }

    /**
     * 查找所有权限列表
     * @return
     */
    @GetMapping("/findAllByControllerAsc")
    @SystemControllerLog(descrption = "查找所有权限列表", actionType = "4")
    public ResponseEntity<List<Permission>> findAllByControllerAsc(){
        List<Permission> permissions = permissionService.findAllByControllerAsc();
        return ResponseEntity.ok(permissions);
    }

    /**
     *按controller分组查询所有权限列表
     * @return
     */
    @GetMapping("/assignPermissions")
    @SystemControllerLog(descrption = "按controller分组查询所有权限列表", actionType = "4")
    public ResponseEntity<LinkedHashMap<String, List<Permission>>> assignPermissions(){
        LinkedHashMap<String, List<Permission>> listLinkedHashMap =permissionService.assignPermissions();
        return ResponseEntity.ok(listLinkedHashMap);
    }

}
