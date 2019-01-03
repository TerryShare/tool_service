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
    public  Verify(int id,String emailtext,String nottext){
        this.id=id;
        this.emailtext=emailtext;
        this.nottext=nottext;
    }

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增策略
    private Integer id; //实体唯一标识

    @Size(max = 20)
    @Column(length = 20)
    private String email;

    @Size(max = 20)
    @Column(length = 20)
    private String note;

    @Size(max = 10)
    @Column(length = 10)
    private  String emailtext;//邮箱验证

    @Size(max = 10)
    @Column(length = 10)
    private  String nottext;//短信验证

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailtext() {
        return emailtext;
    }

    public void setEmailtext(String emailtext) {
        this.emailtext = emailtext;
    }

    public String getNottext() {
        return nottext;
    }

    public void setNottext(String nottext) {
        this.nottext = nottext;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
