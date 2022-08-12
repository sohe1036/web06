package com.company.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.company.shop.vo.MemberVO;

@Mapper
public interface MemberDAO {
	public List<MemberVO> selectListMember(MemberVO memberVO) throws Exception;
	public MemberVO getMember(String userid) throws Exception;
	
	public void addMember(MemberVO memberVO) throws Exception;
	
	public MemberVO login(String userid) throws Exception;
	
	public int checkId(String userid) throws Exception;
	
	public void updateMember(String userid) throws Exception;
	
	public void deleteMember(String userid) throws Exception;
}
