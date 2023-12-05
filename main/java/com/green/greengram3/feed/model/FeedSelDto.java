package com.green.greengram3.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.greengram3.common.Const;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class FeedSelDto {
    private int page;
    private int loginedIuser;

    @JsonIgnore
    private int startIdx;
    @JsonIgnore
    private int rowCount= Const.FEED_COUNT_PER_PAGE;
    @Schema(title = "프로필 주인 유저 pk")
    private int targetIuser;
    private int isFavList;

    public void setPage(int page){

        this.page=page;
        this.rowCount= Const.FEED_COUNT_PER_PAGE;
        this.startIdx=(page-1)*rowCount;
    }
}
