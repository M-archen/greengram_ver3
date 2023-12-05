package com.green.greengram3.user.model;

import lombok.Data;

@Data
public class UserInfoVo {
    private int feedCnt;//작성한 게시글 수
    private int favCnt;//등록한 피드에 달린 좋아요 수
    private String nm;
    private String createdAt;
    private String pic;
    private int follower;//팔로워 수targetIuser을 팔로우 하는사람(
    private int following;//팔로잉 수 targetIuser가 팔로우 하는 사람
    private int followState;
    //1-loginedIuser가 targetIuser를 팔로우한 상황.
    //2-targetIuser가 loginedIuser를 필로우 한 상황
    //3-둘다 팔로우 한 상황.
}
