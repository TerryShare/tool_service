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
    private VerifyRepository verifyRepository;


    @Override
    public boolean setVerify(Verify verify) {
      boolean  i = verifyRepository.save(verify);
        return i;
    }
}
