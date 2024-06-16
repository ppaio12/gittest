package com.exam.service;

import com.exam.dto.MemberDTO;

import java.util.Map;

public interface MemberService {

    public MemberDTO idCheck(String userid);
    public int memberAdd(MemberDTO dto);
    public MemberDTO login(Map<String, String> map);
    public MemberDTO myPage(String userid);

}
