package com.cc.backend.dao.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class RegisterInfoDTO {
   @NotBlank(message = "用户名不能为空")
   private String username;

   @NotBlank(message = "邮箱不能为空")
   @Email(message = "邮箱格式不正确")
   private String email;

   @NotBlank(message = "手机号不能为空")
   @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
   private String phone;

   @NotBlank(message = "密码不能为空")
   private String password;

   @NotNull(message = "验证码不能为空")
   @Pattern(regexp = "^[0-9]{6}$", message = "验证码错误")
   private Integer verificationCode;
}
