package com.xmmems.auth.controller;

import com.xmmems.auth.service.AuthService;
import com.xmmems.common.auth.domain.SysUserToken;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/verify")
    @SystemControllerLog(descrption = "验证用户信息",actionType = "4")
    public ResponseEntity<SysUserToken> verifyUser(HttpServletRequest request, HttpServletResponse response){
        SysUserToken userToken = authService.verifyUser(request, response);
        return ResponseEntity.ok(userToken);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request, HttpServletResponse response){
        authService.logout(request, response);
        return ResponseEntity.ok().build();
    }

}
