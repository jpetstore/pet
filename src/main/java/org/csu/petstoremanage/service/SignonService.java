package org.csu.petstoremanage.service;

import org.csu.petstoremanage.domain.SignOn;
import org.springframework.stereotype.Service;

@Service
public interface SignonService {

    public void updateSignon(SignOn signOn);
    public void resetPassword(String id, String newPassword) ;
}
