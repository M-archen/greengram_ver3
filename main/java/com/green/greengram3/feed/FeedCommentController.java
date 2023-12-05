package com.green.greengram3.feed;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.FeedCommentInsDto;
import com.green.greengram3.feed.model.FeedCommentSelDto;
import com.green.greengram3.feed.model.FeedCommentSelIFeedDto;
import com.green.greengram3.feed.model.FeedCommentSelVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feed/comment")
public class FeedCommentController {
    private final FeedCommentService commentService;
    @PostMapping
    public ResVo feedComment(@RequestBody FeedCommentInsDto dto) {

        return commentService.feedComment(dto);
    }
    @GetMapping
    public List<FeedCommentSelVo> getFeedCommentAll(int ifeed){// 댓글 4~999까지으 레코드만 리턴
        return commentService.getFeedCommentAll(ifeed);
    }

}
