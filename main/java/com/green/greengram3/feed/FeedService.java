package com.green.greengram3.feed;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.green.greengram3.common.Const.*;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper feedMapper;
    private final FeedPicsMapper feedPicsMapper;
    private final FeedFavMapper feedFavMapper;
    private final FeedCommentMapper feedCommentMapper;
    public ResVo postFeed(FeedInsDto dto){
        FeedInsProcVo procVo=new FeedInsProcVo();
        procVo.setLocation(dto.getLocation());
        procVo.setPics(dto.getPics());
        procVo.setIuser(dto.getIuser());
        procVo.setContents(dto.getContents());
        int feedResult= feedMapper.postFeed(procVo);
        if(feedResult==0){
            return new ResVo(0);
        }

        int picsResult=feedPicsMapper.feedPics(procVo);
        if(picsResult==0){
            return new ResVo(0);
        }
        return new ResVo(procVo.getIfeed());
    }
    public List<FeedSelVo> feedSel(FeedSelDto dto){
        List<FeedSelVo> feedSelVoList
                =feedMapper.selFeedAll(dto);
        FeedCommentSelDto fcDto=new FeedCommentSelDto();
        fcDto.setStartIdx(0);
        fcDto.setRowCount(4);
        for (FeedSelVo feed: feedSelVoList) {
            List<String> selFeedPicsAll = feedPicsMapper.selFeedPicsAll(feed.getIfeed());
            feed.setPics(selFeedPicsAll);
            fcDto.setIfeed(feed.getIfeed());
            List<FeedCommentSelVo> comments=feedCommentMapper.selFeedCommentAll(fcDto);
            feed.setComments(comments);
            if(comments.size()==4){
                feed.setIsMoreComment(1);
                comments.remove(3);
            }
        }
        return feedSelVoList;
    }
    public ResVo feedFav(FeedFavDto dto){
        int result=feedFavMapper.iDontLikeYourFeed(dto);
        if(result==1){
            return new ResVo(FEED_FAV_DEL);//삭제완료
        }
        feedFavMapper.iLoveYourFeed(dto);
        return new ResVo(FEED_FAV_INT);//조와요
    }
    public ResVo feedDel(FeedDelDto dto){
        feedFavMapper.delFavAsFeedDel(dto);
        feedCommentMapper.deelFeedAsFeeddDel(dto);
        feedPicsMapper.delPicsASFeedDel(dto);

        int result=feedMapper.delFeed(dto);
        return new ResVo(result);
    }

}
