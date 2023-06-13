package com.cc.backend.dao.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class RegisterInfoDTO {
    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
//    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "请输入正确的邮箱地址")
    private String email;

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
    private String phone;

    @NotBlank(message = "密码不能为空")
    private String password;

//    @NotNull(message = "验证码不能为空")
    @Digits(integer = 6, fraction = 0)
    private Integer verificationCode;
}
