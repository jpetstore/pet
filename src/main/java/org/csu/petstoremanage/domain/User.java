package org.csu.petstoremanage.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("account")
public class User {
    private String id;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String addr1;
    private String addr2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String status;

}