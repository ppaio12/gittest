package com.exam.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.exam.dto.MemberDTO;

import java.util.Map;

@Mapper
public interface MemberMapper {

    public MemberDTO idCheck(String userid);
    public int memberAdd(MemberDTO dto);
    public MemberDTO login(Map<String, String> map);
    public MemberDTO myPage(String userid);
}
