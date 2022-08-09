package com.company.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.company.shop.vo.MemberVO;

@Mapper
public interface MemberDAO {
	public List<MemberVO> selectListMember(MemberVO memberVO);
	public MemberVO getMember(String userid);
}
