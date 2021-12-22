package com.project.shop.projectshop.businessflow.user;

import com.project.shop.projectshop.busibess.user.RegisterBusiness;
import com.project.shop.projectshop.model.exception.ValidateException;
import com.project.shop.projectshop.model.user.request.RegisterRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterBusinessflow {

    private @Autowired RegisterBusiness registerBusiness;
    public String register(RegisterRequest request) throws ValidateException{
        registerBusiness.validateEmailDuplicate(request.getEmail());
        registerBusiness.validateNameDuplicate(request.getUserName());
        registerBusiness.validatepasswordIsNull(request.getPassword());
        return registerBusiness.saveRegister(request);
    }
}
