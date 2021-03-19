package com.xmmems.controller.system;

import com.github.pagehelper.PageInfo;
import com.xmmems.domain.role.Menu;
import com.xmmems.dto.MenuDTO;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.system.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;


    /**
     * 分页查询菜单
     *
     * @param limit
     * @param page
     * @param name
     * @return
     */
    @GetMapping("/paginate")
    @SystemControllerLog(descrption = "分页查询菜单列表", actionType = "4")
    public ResponseEntity<PageInfo<Menu>> sitePageQuery(@RequestParam(value = "limit", defaultValue = "100000000") Integer limit,
                                                        @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                        @RequestParam(value = "name", required = false) String name) {
        PageInfo<Menu> pageResult = menuService.pageQuery(limit, page, name);
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 根据id查找菜单
     *
     * @param id
     * @return
     */
    @GetMapping("/findById")
    @SystemControllerLog(descrption = "根据id查询菜单", actionType = "4")
    public ResponseEntity<MenuDTO> findById(@RequestParam(value = "id") Integer id) {
        MenuDTO menu = menuService.findById(id);
        return ResponseEntity.ok(menu);
    }


    /**
     * 添加菜单
     *
     * @param menu
     * @return
     */
    @PostMapping("/save")
    @SystemControllerLog(descrption = "添加菜单", actionType = "1")
    public ResponseEntity<Void> save(@RequestBody Menu menu) {
        menuService.save(menu);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 更新菜单
     *
     * @param menu
     * @return
     */
    @PostMapping("/update")
    @SystemControllerLog(descrption = "修改菜单", actionType = "2")
    public ResponseEntity<Void> update(@RequestBody Menu menu) {
        menuService.update(menu);
        return ResponseEntity.ok().build();
    }

    /**
     * 根据id删除菜单
     *
     * @param id
     * @return
     */
    @PostMapping("/delete")
    @SystemControllerLog(descrption = "根据id删除菜单", actionType = "3")
    public ResponseEntity<Void> delete(@RequestParam(value = "id") Integer id) {
        menuService.delete(id);
        return ResponseEntity.ok().build();
    }

    /**
     * 通过一级菜单id查找所在的一级二级三级菜单
     *
     * @param pcode
     * @return
     */
    @GetMapping("/findByPid")
    @SystemControllerLog(descrption = "通过一级菜单id查找所在的一级二级三级菜单", actionType = "4")
    public ResponseEntity<List<Map<String, Object>>> findByPid(@RequestParam(value = "pcode") String  pcode) {
        List<Map<String, Object>> list = menuService.findByPid(pcode);
        return ResponseEntity.ok(list);
    }

    /**
     * 查找所有一级菜单
     *
     * @return
     */
    @GetMapping("/findPmenu")
    @SystemControllerLog(descrption = "查找所有一级菜单", actionType = "4")
    public ResponseEntity<List<MenuDTO>> findPmenu() {
        List<MenuDTO> menu = menuService.findPmenu();
        System.out.println("**********findPmenu"+menu);
        return ResponseEntity.ok(menu);
    }

//    /**
//     * 分组查询所有菜单信息
//     *
//     * @return
//     */
//    @GetMapping("/assignMenu")
//    @SystemControllerLog(descrption = "分组查询所有菜单信息", actionType = "4")
//    public ResponseEntity<List<Map<String, Object>>> assignMenu() {
//        List<Map<String, Object>> o = menuService.assignMenu();
//        return ResponseEntity.ok(o);
//    }

    @GetMapping("/findByAccountId")
    @SystemControllerLog(descrption = "根据账户id查询菜单", actionType = "4")
    public ResponseEntity<List<MenuDTO>> findByAccountId() {
        List<MenuDTO> list = menuService.findByAccountId();
        return ResponseEntity.ok(list);
    }

    /**
     * 根据角色id查询所有菜单，如果没有，则查询全部菜单
     * @param roleId
     * @return
     */
    @GetMapping("/findMenuTree")
    @SystemControllerLog(descrption = "树结构查询菜单(根据角色id)", actionType = "4")
    public ResponseEntity<List<Map<String,Object>>> findMenuTree(@RequestParam(value = "roleId",required = false) Integer roleId){
        List<Map<String, Object>> list = menuService.findMenuTree(roleId);
        return ResponseEntity.ok(list);
    }

}
