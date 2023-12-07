package com.green.greengram3.dm.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class DmUserInsDto {
    private int iuser;
    private int idm;
}
