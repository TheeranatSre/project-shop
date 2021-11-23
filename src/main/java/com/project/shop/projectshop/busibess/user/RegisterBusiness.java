package com.project.shop.projectshop.busibess.user;

import java.util.Optional;

import com.project.shop.projectshop.model.exception.ValidateException;
import com.project.shop.projectshop.model.user.UserEntity;
import com.project.shop.projectshop.model.user.request.RegisterRequest;
import com.project.shop.projectshop.repository.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterBusiness {

    private @Autowired UserRepository userRepository;

    public void validateEmailDuplicate(String email) throws ValidateException {
        Optional<UserEntity> user = userRepository.findOneByEmail(email);
        if (!user.isEmpty()) {
            throw new ValidateException("ที่อยู่ Email นี้ถูกใช้แล้ว กรุณากรอกที่อยู่ Email ใหม่");
        }
    }

    public void validateNameDuplicate(String name) throws ValidateException{
        Optional<UserEntity> user = userRepository.findOneByName(name);
        if (!user.isEmpty()) {
            throw new ValidateException("User Name นี้ถูกใช้แล้ว กรุณากรอกที่อยู่ User Name ใหม่");
        }
    }

    public String saveRegister(RegisterRequest request) {
        UserEntity userRegister = new UserEntity();
        userRegister.setEmail(request.getEmail());
        userRegister.setName(request.getUserName());
        userRegister.setPassword(request.getPassword());
        userRegister.setRole("user");
        userRepository.save(userRegister);
        return"สมัครผู้ใช้สำเร็จ";
    }
}
