package com.green.greengram3.feed;

import com.green.greengram3.feed.model.FeedInsProcVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedPicsMapper {
    int feedPics(FeedInsProcVo dto);
    List<String> selFeedPicsAll(int ifeed);
}
