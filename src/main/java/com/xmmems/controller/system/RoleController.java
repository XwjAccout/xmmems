package com.xmmems.controller.system;

import com.xmmems.domain.role.Role;
import com.xmmems.dto.PageResult;
import com.xmmems.dto.RoleDTO;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.system.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;


    /**
     * 分页查询角色
     * @param limit
     * @param page
     * @param siteName
     * @return
     */
    @GetMapping("/paginate")
    @SystemControllerLog(descrption = "分页查询角色列表", actionType = "4")
    public ResponseEntity<PageResult<Role>> sitePageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                                @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                @RequestParam(value = "siteName", required = false) String siteName){
        PageResult<Role> pageResult = roleService.pageQuery(limit, page, siteName);
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 根据id查找角色
     * @param id
     * @return
     */
    @GetMapping("/findById")
    @SystemControllerLog(descrption = "根据id查询角色", actionType = "4")
    public ResponseEntity<Role> findById(@RequestParam(value = "id") Integer id){
        Role role = roleService.findById(id);
        return ResponseEntity.ok(role);
    }

    /**
     * 添加角色
     * @param name
     * @return
     */
    @PostMapping("/save")
    @SystemControllerLog(descrption = "添加角色", actionType = "1")
    public ResponseEntity<Void> save(@RequestParam(value = "name") String name){
        roleService.save(name);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 更新角色
     * @param role
     * @return
     */
    @PostMapping("/update")
    @SystemControllerLog(descrption = "修改角色", actionType = "2")
    public ResponseEntity<Void> update(@RequestBody Role role){
        roleService.update(role);
        return ResponseEntity.ok().build();
    }

    /**
     * 根据id删除角色
     * @param id
     * @return
     */
    @PostMapping("/delete")
    @SystemControllerLog(descrption = "根据id删除角色", actionType = "3")
    public ResponseEntity<Void> delete(@RequestParam(value = "id") Integer id){
        roleService.delete(id);
        return ResponseEntity.ok().build();
    }


    /**
     * 查询所有角色信息
     * @return
     */
    @GetMapping("/findAll")
    @SystemControllerLog(descrption = "查询所有角色信息", actionType = "4")
    public ResponseEntity<List<RoleDTO>> findAll(){
        List<RoleDTO> roles = roleService.findAll();
        return ResponseEntity.ok(roles);
    }

    /**
     *根据roleId，permissionId添加权限
     * @param roleId
     * @param permissionId
     * @return
     */
    @PostMapping("/savePermission")
    @SystemControllerLog(descrption = "给角色分配权限", actionType = "1")
    public ResponseEntity<Void> savePermission(@RequestParam(value = "roleId") Integer roleId,
                                         @RequestParam(value = "permissionId") Integer permissionId) {
        roleService.savePermission(roleId, permissionId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 根据roleId，permissionId删除权限
     * @param roleId
     * @param permissionId
     * @return
     */
    @PostMapping("/deletePermission")
    @SystemControllerLog(descrption = "给角色删除权限", actionType = "3")
    public ResponseEntity<Void> deletePermission(@RequestParam(value = "roleId") Integer roleId,
                                           @RequestParam(value = "permissionId") Integer permissionId) {
        roleService.deletePermission(roleId, permissionId);
        return ResponseEntity.ok().build();
    }

    /**
     * 根据roleId，menuId添加菜单
     * @param roleId
     * @param menuId
     * @return
     */
    @PostMapping("/saveMenu")
    @SystemControllerLog(descrption = "给角色分配菜单", actionType = "1")
    public ResponseEntity<Void> saveMenu(@RequestParam(value = "roleId") Integer roleId,
                                               @RequestParam(value = "menuId") Integer menuId) {
        roleService.saveMenu(roleId, menuId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 根据roleId，menuId删除菜单
     * @param roleId
     * @param menuId
     * @return
     */
    @PostMapping("/deleteMenu")
    @SystemControllerLog(descrption = "给角色删除菜单", actionType = "3")
    public ResponseEntity<Void> deleteMenu(@RequestParam(value = "roleId") Integer roleId,
                                                 @RequestParam(value = "menuId") Integer menuId) {
        roleService.deleteMenu(roleId, menuId);
        return ResponseEntity.ok().build();
    }

    /**
     *根据roleId，otherPowerId添加其他权限
     * @param roleId
     * @param otherPowerId
     * @return
     */
    @PostMapping("/saveotherPower")
    @SystemControllerLog(descrption = "给角色分配其他权限", actionType = "1")
    public ResponseEntity<Void> saveotherPower(@RequestParam(value = "roleId") Integer roleId,
                                         @RequestParam(value = "otherPowerId") Integer otherPowerId) {
        roleService.saveotherPower(roleId, otherPowerId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 根据roleId，otherPowerId删除其他权限
     * @param roleId
     * @param otherPowerId
     * @return
     */
    @PostMapping("/deleteotherPower")
    @SystemControllerLog(descrption = "给角色删除其他权限", actionType = "3")
    public ResponseEntity<Void> deleteotherPower(@RequestParam(value = "roleId") Integer roleId,
                                           @RequestParam(value = "otherPowerId") Integer otherPowerId) {
        roleService.deleteotherPower(roleId, otherPowerId);
        return ResponseEntity.ok().build();
    }
}
