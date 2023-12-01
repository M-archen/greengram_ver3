package com.green.greengram3.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class FeedCommentSelVo {
    @JsonIgnore
    private int ifeedComment;
    private String comment;
    private String createdAt;
    private int writerIuser;
    private String writerNm;
    private String writerPic;
}
