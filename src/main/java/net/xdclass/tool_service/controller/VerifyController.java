package net.xdclass.tool_service.controller;

import net.xdclass.tool_service.entity.Verify;
import net.xdclass.tool_service.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 验证控制器
 * Greated by Terry on 2019/1/3
 * Time: 17:26
 */
@RestController
@RequestMapping("/v1/verify/")
public class VerifyController {

    @Autowired
    private VerifyService verifyService;

    @RequestMapping("/index")
    public Object from(){
        Verify v=new Verify();
        v.setId(1);
        v.setEmail("12323@qq.com");
        v.setNote("122312");
        v.setEmailtext("1234");
        v.setNottext("1333");
        Verify b=verifyService.setVerify(v);
        System.out.println(b+"!!!!!!!!!!");
        Verify em=verifyService.findbyemail("12323@qq.com");
        System.out.println(em+"11111111111111111111");
        return new ModelAndView("/fromelements");
    }

    @RequestMapping("/email")

    public Object email(String  requestDate){


        return  "";
    }

}
