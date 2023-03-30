package org.csu.petstoremanage.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("signon")
public class SignOn {
    private String id;
    private String password;
}
