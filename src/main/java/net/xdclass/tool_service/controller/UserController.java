package net.xdclass.tool_service.controller;

import net.sf.json.JSONObject;
import net.xdclass.tool_service.entity.User;
import net.xdclass.tool_service.service.UserService;

import net.xdclass.tool_service.util.Note;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


/**
 * Greated by Terry on 2018/12/26
 * Time: 10:58
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());


    @Autowired
    private UserService userService;

    @GetMapping("login")
    public  Object login(){
        return  new ModelAndView("/logins");
    }

    @PostMapping("logins")
    @ResponseBody
    public Object logins(String requestDate, HttpSession session) {
        User user = new User();
        Map map = new HashMap();
        JSONObject requestJson = JSONObject.fromObject(requestDate);
        map.put("username", requestJson.getString("username"));
        map.put("password", requestJson.getString("password"));
        user.setUsername(requestJson.getString("username"));
        user.setPassword(requestJson.getString("password"));
        User users = userService.FindByUser(requestJson.getString("username"), requestJson.getString("password"));

        if (users == null) {
            System.out.println("Incorrect Username or Password! Please try again");
            Map reMap = new HashMap();
            reMap.put("succ", "false");
            JSONObject jsonObject = JSONObject.fromObject(reMap);
            return jsonObject.toString();
        }else {
            session.setAttribute("code", users.getCode());
            System.out.println("Login Successfully");
            Map reMap = new HashMap();
            reMap.put("succ", "1");
            JSONObject jsonObject = JSONObject.fromObject(reMap);
            return jsonObject.toString();

        }

    }
    @GetMapping("/index")
    public Object index (HttpSession session) {
        Object code = session.getAttribute("code");
        int codes = (int) code;
        if (codes == 0) {
            System.out.println(code);
            System.out.println("Account not activated");
            Map reMap = new HashMap();
            reMap.put("succ", "");
            JSONObject jsonObject = JSONObject.fromObject(reMap);
            return jsonObject.toString();
        }else{
            System.out.println("");
        }
        return "";
    }

    @GetMapping("/login-error")
    public String loginError (Model model){
        model.addAttribute("loginError", true);
        model.addAttribute("errorMsg", "登录失败，用户名或者密码错误！");
        return "login";
    }

    @GetMapping("save")
    public Object save (User user){
        userService.registerUser(user);
        return null;
    }


    @GetMapping("loginout")
    @ResponseBody
    public Object loginout () {

        return new ModelAndView("/logins");
    }

    @GetMapping("send")
    public String send(){
        String sender="1196319567@qq.com";
        String receiver="yuankai.gu@bespinglobal.cn";
        String title="Test Email";
        String test ="hi guyuankai!!";//验证信息
        String result=userService.send(sender,receiver,title,test);
        return result;
    }

    @GetMapping("note")
    public String note() throws IOException, URISyntaxException {
        Map map=new HashMap();

        String key="c2ebdebb356b2d6e408941d9b8687937";
        String code= "LOVEYOU";
        String mobile="15127062120";
        long tpl_id=2685170;
        String codes=URLEncoder.encode("#code#") + "="
                + URLEncoder.encode(code);
        userService.notes(key,tpl_id,codes,mobile);
        return "1";
    }

}
