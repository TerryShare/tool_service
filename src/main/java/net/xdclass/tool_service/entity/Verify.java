package net.xdclass.tool_service.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Greated by Terry on 2019/1/3
 * Time: 17:32
 */
@Entity(name = "verify") //实体
public class Verify {
    public  Verify(){}
    public  Verify(int id,int emailtext,int nottext){
        this.id=id;
        this.emailtext=emailtext;
        this.nottext=nottext;
    }

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增策略
    @Size(max = 11)
    private int id; //实体唯一标识

    @Size(max = 4)
    @Column(length = 4)
    private  int emailtext;//邮箱验证

    @Size(max = 4)
    @Column(length = 4)
    private  int nottext;//短信验证

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmailtext() {
        return emailtext;
    }

    public void setEmailtext(int emailtext) {
        this.emailtext = emailtext;
    }

    public int getNottext() {
        return nottext;
    }

    public void setNottext(int nottext) {
        this.nottext = nottext;
    }
}
