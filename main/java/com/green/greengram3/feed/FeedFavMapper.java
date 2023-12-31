package com.green.greengram3.feed;

import com.green.greengram3.feed.model.FeedDelDto;
import com.green.greengram3.feed.model.FeedFavDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedFavMapper {
    int iDontLikeYourFeed(FeedFavDto dto);
    int iLoveYourFeed(FeedFavDto dto);
    int delFavAsFeedDel(FeedDelDto dto);
}
