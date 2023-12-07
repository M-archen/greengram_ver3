package com.green.greengram3.dm;

import com.green.greengram3.dm.model.DmMsgSelDto;
import com.green.greengram3.dm.model.DmMsgSelVo;
import com.green.greengram3.dm.model.DmUserInsDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmMapper {
    int insDmuser(DmUserInsDto dto);

    List<DmMsgSelVo> selDmMsgAll(DmMsgSelDto dto);
}
