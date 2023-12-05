package com.green.greengram3.user;


import com.green.greengram3.common.ResVo;
import com.green.greengram3.user.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    //회원가입//
    public ResVo signup(UserSignupDto dto){

        String mixedUpw=BCrypt.hashpw(dto.getUpw(),BCrypt.gensalt());
        dto.setUpw(mixedUpw);
        UserSignUpProcDto ProcDto= UserSignUpProcDto.builder()
                .nm(dto.getNm())
                .pic(dto.getPic())
                .uid(dto.getUid())
                .upw(dto.getUpw())
                .build();
        int result=userMapper.signUp(ProcDto);
        if(result==0){
            return new ResVo(0);
        }
        return new ResVo(ProcDto.getIuser());
    }
    public UserSignInVo signin(UserSignInDto dto){
        UserSignInProcVo vo=userMapper.signIn(dto);
        UserSignInVo signInVo=new UserSignInVo();
        if(vo==null){
            signInVo.setResult(2);
            return signInVo;
        }
        if(!BCrypt.checkpw(dto.getUpw(),vo.getUpw())){
            signInVo.setResult(3);
            return signInVo;
        }
        signInVo.setNm(vo.getNm());
        signInVo.setIuser(vo.getIuser());
        signInVo.setPic(vo.getPic());
        signInVo.setResult(1);
        return signInVo;
    }
    public ResVo toggleFollow(UserFollowDto dto){
        int result= userMapper.followNo(dto);

        if(result==1){
            return new ResVo(0);
        }
        result=userMapper.followYes(dto);
        return new ResVo(result);
    }
    public UserInfoVo userInfo(UserInfoSelDto dto){
        UserInfoVo userInfoVo =userMapper.userSelInfo(dto);
        return userInfoVo;
    }


}
