package com.exam.service;

import com.exam.dto.MemberDTO;
import com.exam.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {

    MemberMapper memberMapper;

    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }
    @Override
    public MemberDTO idCheck(String userid) {
        return memberMapper.idCheck(userid);
    }

    @Override
    public int memberAdd(MemberDTO dto) {
        return memberMapper.memberAdd(dto);
    }

    @Override
    public MemberDTO login(Map<String, String> map) {
        return memberMapper.login(map);
    }

    @Override
    public MemberDTO myPage(String userid) {
        return memberMapper.myPage(userid);
    }


}
