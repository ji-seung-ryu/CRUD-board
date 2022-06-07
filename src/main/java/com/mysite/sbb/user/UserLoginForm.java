package com.mysite.sbb.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginForm {
    @Size(min = 3, max = 25)
    @NotEmpty(message = "�����ID�� �ʼ��׸��Դϴ�.")
    private String identity;

    @NotEmpty(message = "��й�ȣ�� �ʼ��׸��Դϴ�.")
    private String password;
}