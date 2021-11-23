package com.project.shop.projectshop.model.user.request;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoginRequest {
    @NotNull(message = "กรุณาระบุ user name")
    private String userName;

    @NotNull(message = "กรุณาระบุ password")
    private String password;
}
