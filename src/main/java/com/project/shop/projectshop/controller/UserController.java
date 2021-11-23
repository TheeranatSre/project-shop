package com.project.shop.projectshop.controller;

import java.util.List;

import com.project.shop.projectshop.busibess.user.LoginBusiness;
import com.project.shop.projectshop.businessflow.user.RegisterBusinessflow;
import com.project.shop.projectshop.model.exception.ValidateException;
import com.project.shop.projectshop.model.user.UserEntity;
import com.project.shop.projectshop.model.user.request.LoginRequest;
import com.project.shop.projectshop.model.user.request.RegisterRequest;
import com.project.shop.projectshop.model.user.response.UserResponse;
import com.project.shop.projectshop.repository.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private @Autowired UserRepository userRepository;
    private @Autowired RegisterBusinessflow registerBusinessflow;
    private @Autowired LoginBusiness loginBusiness;

    @GetMapping("/user-all")
    public List<UserEntity> getUserAll() {
        return userRepository.findAll();
    }

    @PostMapping("/register")
    public String userRegister(@RequestBody @Validated RegisterRequest request) throws ValidateException {
        return registerBusinessflow.register(request);
    }

    @PostMapping("/login")
    public UserResponse login(@Validated @RequestBody LoginRequest request) throws ValidateException{
        return loginBusiness.login(request);
    }
}
