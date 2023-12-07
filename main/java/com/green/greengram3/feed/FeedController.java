package com.green.greengram3.feed;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feed")
public class FeedController {
    private final FeedService feedService;
    @Operation(summary = "피드 등록",description = "피드 등록 처리")
    @PostMapping
    public ResVo postFeed(@RequestBody FeedInsDto dto){
        return feedService.postFeed(dto);
    }
    @GetMapping
    @Operation(summary = "피드 리스트", description = "전체 피드 리스트, 특정 사용자 프로필 화면에서 사용할 피드 리스트, 한 페이지 30개 피드 가져옴")
    @Parameters(value = {
            @Parameter(name="page", description = "page값")
    })
    public List<FeedSelVo> selFeed(FeedSelDto dto){
        return feedService.feedSel(dto);
    }
    @GetMapping("/fav")
    public ResVo feedFav( FeedFavDto dto){
        log.info("FeedFavDto : {}",dto);
        return feedService.feedFav(dto);
    }
    @DeleteMapping
    public ResVo delFeed( FeedDelDto dto){
        log.info("FeedDelDto : {}",dto);
        return feedService.feedDel(dto);
    }
}
