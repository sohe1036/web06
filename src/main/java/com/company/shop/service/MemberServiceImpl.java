package com.company.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.shop.dao.MemberDAO;
import com.company.shop.vo.MemberVO;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDAO memberDAO;

	@Override
	public List<MemberVO> selectListMember(MemberVO memberVO) throws Exception {
		return memberDAO.selectListMember(memberVO);
	}

	@Override
	public MemberVO getMember(String userid) throws Exception {
		return memberDAO.getMember(userid);
	}

}
