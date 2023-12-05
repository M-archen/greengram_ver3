package com.green.greengram3.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserSignUpProcDto {
    private int iuser;
    private String nm;
    private String uid;
    private String upw;
    private String pic;
}
