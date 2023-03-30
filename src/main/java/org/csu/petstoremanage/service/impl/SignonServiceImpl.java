package org.csu.petstoremanage.service.impl;

import org.csu.petstoremanage.domain.SignOn;
import org.csu.petstoremanage.persistence.SignonMapper;
import org.csu.petstoremanage.service.SignonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignonServiceImpl implements SignonService {

    @Autowired
    private SignonMapper signonMapper;

    @Override
    public void updateSignon(SignOn signOn) {
        signonMapper.updateById(signOn);
    }

    public void resetPassword(String id, String newPassword) {
        SignOn signOn=new SignOn();
        signOn.setId(id);
        signOn.setPassword(newPassword);
        signonMapper.updateById(signOn);
    }
}
