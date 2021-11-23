package com.project.shop.projectshop.coverter.user;


import com.project.shop.projectshop.model.user.UserEntity;
import com.project.shop.projectshop.model.user.response.UserResponse;

import org.springframework.stereotype.Component;

@Component
public class UserLoginConverter {
    public UserResponse convertToUserLoginResponse(UserEntity user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setUserName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setRole(user.getRole());
        return userResponse;
    }
}
