package com.green.greengram3.user;

import com.green.greengram3.user.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@Mapper
public interface UserMapper {
    int signUp(UserSignUpProcDto dto);
    UserSignInProcVo signIn(UserSignInDto dto);
    int followNo(UserFollowDto dto);
    int followYes(UserFollowDto dto);
    UserInfoVo userSelInfo(UserInfoSelDto dto);
}
