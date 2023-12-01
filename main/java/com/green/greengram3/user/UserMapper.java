package com.green.greengram3.user;

import com.green.greengram3.user.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int signUp(UserSignUpProcDto dto);
    UserSignInProcVo signIn(UserSignInDto dto);
}
