package net.xdclass.tool_service.repository;

import net.xdclass.tool_service.entity.Verify;
import org.springframework.data.repository.CrudRepository;

/**
 * Greated by Terry on 2019/1/3
 * Time: 17:35
 */
public interface VerifyRepository extends CrudRepository<Verify ,Long> {



    Verify save(Verify verify);


    Verify findByEmail(String email);

}
