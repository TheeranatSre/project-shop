package com.project.shop.projectshop.busibess.user;

import java.util.Optional;

import com.project.shop.projectshop.coverter.user.UserLoginConverter;
import com.project.shop.projectshop.model.exception.ValidateException;
import com.project.shop.projectshop.model.user.UserEntity;
import com.project.shop.projectshop.model.user.request.LoginRequest;
import com.project.shop.projectshop.model.user.response.UserResponse;
import com.project.shop.projectshop.repository.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginBusiness {

    private @Autowired UserRepository userRepository;
    private @Autowired UserLoginConverter userLoginConverter;

    public UserResponse login(LoginRequest request) throws ValidateException {
        Optional<UserEntity> otp = userRepository.findOneByName(request.getUserName());
        if (otp.isEmpty()) {
            throw new ValidateException("ที่อยู่ Email ไม้ถูกต้อง กรุณากรอกที่อยู่ Email ใหม่");
        }

        UserEntity user = otp.get();
        if (!user.getPassword().equals(request.getPassword())) {
            throw new ValidateException("password ไม้ถูกต้อง กรุณากรอกที่อยู่ password ใหม่");
        }
        return userLoginConverter.convertToUserLoginResponse(user);
    }
}
