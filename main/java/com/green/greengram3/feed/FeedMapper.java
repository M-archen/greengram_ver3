package com.green.greengram3.feed;
import com.green.greengram3.feed.model.FeedDelDto;
import com.green.greengram3.feed.model.FeedInsProcVo;
import com.green.greengram3.feed.model.FeedSelDto;
import com.green.greengram3.feed.model.FeedSelVo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface FeedMapper {
    int postFeed(FeedInsProcVo dto);
    List<FeedSelVo> selFeedAll(FeedSelDto dto);
    int delFeed(FeedDelDto dto);
}
