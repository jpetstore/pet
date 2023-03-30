package org.csu.petstoremanage;


import org.csu.petstoremanage.domain.SignOn;
import org.csu.petstoremanage.domain.User;
import org.csu.petstoremanage.persistence.SignonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.List;

@SpringBootTest
public class SignonTest {

    @Autowired
    SignonMapper signonMapper;

    @Test
    public void test() {

        List<SignOn>signOnList=signonMapper.selectList(null);
        String suffixPwd="tiege";
        for(SignOn signOn:signOnList) {
            String primePwd = signOn.getPassword() + suffixPwd;
            String md5Str = DigestUtils.md5DigestAsHex(primePwd.getBytes());
            signOn.setPassword(md5Str);
            signonMapper.updateById(signOn);
            System.out.println(signOn);
        }
    }
}
