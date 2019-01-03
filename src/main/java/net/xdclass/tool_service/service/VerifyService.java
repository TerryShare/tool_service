package net.xdclass.tool_service.service;

import net.xdclass.tool_service.entity.Verify;

/**
 * Greated by Terry on 2019/1/3
 * Time: 17:36
 */
public interface VerifyService {

    Verify setVerify(Verify verify);

    Verify findbyemail(String emile);
}
