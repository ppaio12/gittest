package com.exam.service;

import com.exam.dto.GoodsDTO;
import com.exam.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    GoodsMapper goodsMapper;
    public GoodsServiceImpl(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    @Override
    public List<GoodsDTO> goodsList(String gCategory) {
        return goodsMapper.goodsList(gCategory);
    }

    @Override
    public GoodsDTO goodsRetrieve(String gcode) {
        return goodsMapper.goodsRetrieve(gcode);
    }
}
