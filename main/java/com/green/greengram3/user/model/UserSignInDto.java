package com.green.greengram3.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserSignInDto {
    private String uid;
    private String upw;
}
