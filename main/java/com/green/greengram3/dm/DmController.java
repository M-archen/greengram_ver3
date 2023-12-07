package com.green.greengram3.dm;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.dm.model.DmMsgSelDto;
import com.green.greengram3.dm.model.DmMsgSelVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dm")
public class DmController {
    private final DmService dmService;
    //page,fromIuser,toIuser
    //page=1 ? 방이 없을 수도 있으니 체크=>
    //방이 있으면 대화리스트 응답. 없으면 방 만들고 빈 대화리스트 응답.
    //page>1 방이 있으니 대화리스트 응답.
    @GetMapping("msg")
    public List<DmMsgSelVo> getMsgAll(DmMsgSelDto dto){//@RequestParam (required=true) 가 되어야함.
        // 객체로 보내면 @RequestParam 으로 받으면 안됨.
        log.info(" : {}",dto);
        return dmService.getMsgAll(dto);
    }
}
