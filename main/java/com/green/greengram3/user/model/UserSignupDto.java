package com.green.greengram3.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Schema(title = "회원가입 데이터")
public class UserSignupDto {
    @Schema(title = "유저 이름")
    private String nm;
    @Schema(title = "유저 아이디")
    private String uid;
    @Schema(title = "유저 비밀번호")
    private String upw;
    @Schema(title = "유저 사진")
    private String pic;
}
