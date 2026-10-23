package com.example.baizuhui.controller;

import com.example.baizuhui.service.WechatLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/wechat")
public class WechatLoginController {

    @Autowired
    private WechatLoginService wechatLoginService;

    // 修改为POST请求
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> wechatLogin(@RequestBody Map<String, String> request) {
        String code = request.get("code");
        Map<String, Object> result = wechatLoginService.wechatLogin(code);
        return ResponseEntity.ok(result);
    }
}