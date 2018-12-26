package net.xdclass.tool_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController 测试页面使用
 * Greated by Terry on 2018/12/26
 * Time: 13:42
 */
@RestController
public class TestController {

    @GetMapping("test")
    public Object test(){
        return "register";
    }
}