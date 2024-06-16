package com.exam.mapper;

import com.exam.dto.GoodsDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {

    public List<GoodsDTO> goodsList(String gCategory);
    public GoodsDTO goodsRetrieve(String gCode);


}
