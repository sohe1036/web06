package com.company.shop.service;

import java.util.List;

import com.company.shop.vo.MemberVO;

public interface MemberService {
	public List<MemberVO> selectListMember(MemberVO memberVO) throws Exception;
	public MemberVO getMember(String userid) throws Exception;

	public void addMember(MemberVO memberVO) throws Exception;
	
	public MemberVO login(String userid) throws Exception;
	
	public int checkId(String userid) throws Exception;
}
