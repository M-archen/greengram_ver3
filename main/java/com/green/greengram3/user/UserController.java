package com.green.greengram3.user;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.user.model.UserSignInDto;
import com.green.greengram3.user.model.UserSignInVo;
import com.green.greengram3.user.model.UserSignupDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    @PostMapping("/signup")
    public ResVo postSignup(@RequestBody UserSignupDto userSignupDto){
        log.info("UserSignupDto : {}",userSignupDto);
        return userService.signup(userSignupDto);
    }
    @PostMapping("/signin")
    public UserSignInVo postSignin(@RequestBody UserSignInDto dto){
        log.info("userSignInDto : {}",dto);
        return userService.signin(dto);
    }


}
