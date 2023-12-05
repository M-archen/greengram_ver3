package com.green.greengram3.feed;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.FeedCommentInsDto;
import com.green.greengram3.feed.model.FeedCommentSelDto;
import com.green.greengram3.feed.model.FeedCommentSelIFeedDto;
import com.green.greengram3.feed.model.FeedCommentSelVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedCommentService {
    private final FeedCommentMapper commentMapper;
    public ResVo feedComment(FeedCommentInsDto dto){
        int result=commentMapper.insFeedComment(dto);
        if(result==0){
            return new ResVo(0);//안들어감
        }
        return new ResVo(dto.getIfeedComment());
    }
    public List<FeedCommentSelVo> getFeedCommentAll(int ifeed){
        FeedCommentSelDto dto=new FeedCommentSelDto();
        dto.setRowCount(999);
        dto.setStartIdx(4);
        dto.setIfeed(ifeed);
        List<FeedCommentSelVo> vo=commentMapper.selFeedCommentAll(dto);
        return vo;
    }


}
