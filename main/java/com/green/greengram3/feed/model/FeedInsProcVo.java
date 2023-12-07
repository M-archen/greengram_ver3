package com.green.greengram3.feed.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class FeedInsProcVo {
    private int iuser;
    private int ifeed;
    private String location;
    private String contents;
    private List<String> pics;
}
