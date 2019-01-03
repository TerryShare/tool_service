package net.xdclass.tool_service.service.impl;

import net.xdclass.tool_service.entity.Verify;
import net.xdclass.tool_service.repository.VerifyRepository;
import net.xdclass.tool_service.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Greated by Terry on 2019/1/3
 * Time: 17:36
 */

@Service
public class VerifyServiceImpl implements VerifyService{

    @Autowired
    private VerifyRepository verifyService;


    @Override
    public Verify setVerify(Verify verify) {
      Verify i=  verifyService.save(verify);
        return i;
    }

    @Override
    public Verify findbyemail(String emile) {
       Verify verify= verifyService.findByEmail(emile);
        return verify;
    }

}
