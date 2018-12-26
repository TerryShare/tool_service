package net.xdclass.tool_service.controller;

import net.xdclass.tool_service.entity.User;
import net.xdclass.tool_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Greated by Terry on 2018/12/26
 * Time: 10:58
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("login")
    public  Object login(){
        return  new ModelAndView("/login");
    }

    @GetMapping("save")
    public Object save(User user){
        userService.registerUser(user);
        return null;
    }

    @GetMapping("loginout")
    @ResponseBody
    public Object loginout(){

        return new ModelAndView("/login" );
    }

}
