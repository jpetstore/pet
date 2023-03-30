package org.csu.petstoremanage;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.csu.petstoremanage.domain.User;
import org.csu.petstoremanage.persistence.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.List;

@SpringBootTest
public class UserTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test() {

        List<User>userList=userMapper.selectList(null);
        String suffixPwd="tiege";
        for(User user:userList) {
            String primePwd = user.getPassword() + suffixPwd;
            String md5Str = DigestUtils.md5DigestAsHex(primePwd.getBytes());
            user.setPassword(md5Str);
            userMapper.updateById(user);
            System.out.println(user);
        }
    }
}
