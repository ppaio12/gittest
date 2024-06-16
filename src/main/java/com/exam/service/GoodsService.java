package com.exam.service;

import com.exam.dto.GoodsDTO;

import java.util.List;

public interface GoodsService {
    public List<GoodsDTO> goodsList(String gCategory);
    public GoodsDTO goodsRetrieve(String gcode);
}
