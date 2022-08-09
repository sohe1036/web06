package com.company.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.shop.service.MemberService;
import com.company.shop.vo.MemberVO;

@RestController
@RequestMapping("/member/")
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@RequestMapping("list.do")
	public List<MemberVO> selectListMember(@ModelAttribute("searchVO") MemberVO memberVO, ModelMap model) throws Exception {
		List<MemberVO> mList = memberService.selectListMember(memberVO);
		return mList;
	}
	
	@RequestMapping(value="getMember.do", method=RequestMethod.GET)
	public MemberVO getMember(@RequestParam("userid") String userid, ModelMap model) throws Exception {
			MemberVO member = memberService.getMember(userid);
			return member;
	}
	
	@RequestMapping(value="getMember2/{userid}", method=RequestMethod.GET)
	public MemberVO getMember2(@PathVariable("userid") String userid, ModelMap model) throws Exception {
			MemberVO member = memberService.getMember(userid);
			return member;
	}
}
