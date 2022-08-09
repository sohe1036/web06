package com.company.shop.service;

import java.util.List;

import com.company.shop.vo.MemberVO;

public interface MemberService {
	public List<MemberVO> selectListMember(MemberVO memberVO) throws Exception;
	public MemberVO getMember(String userid) throws Exception;
}
