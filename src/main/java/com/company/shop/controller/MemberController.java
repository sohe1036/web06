
package com.company.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.shop.service.MemberService;
import com.company.shop.vo.MemberVO;

@Controller
@RequestMapping("/member/")
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@ResponseBody
	@RequestMapping("jsonList.do")
	public List<MemberVO> selectJsonListMember(@ModelAttribute("searchVO") MemberVO memberVO, ModelMap model) throws Exception {
		List<MemberVO> mList = memberService.selectListMember(memberVO);
		return mList;
	}
	
	@ResponseBody
	@RequestMapping(value="getJsonMember.do", method=RequestMethod.GET)
	public MemberVO getJsonMember(@RequestParam("userid") String userid, ModelMap model) throws Exception {
			MemberVO member = memberService.getMember(userid);
			return member;
	}
	
	@ResponseBody
	@RequestMapping(value="getJsonMember2/{userid}", method=RequestMethod.GET)
	public MemberVO getJsonMember2(@PathVariable("userid") String userid, ModelMap model) throws Exception {
			MemberVO member = memberService.getMember(userid);
			return member;
	}
	
	@RequestMapping(value="list.do")
	public String selectListMember(@ModelAttribute("searchVO") MemberVO memberVO, Model model) throws Exception {
		List<MemberVO> mList = memberService.selectListMember(memberVO);
		model.addAttribute("mList", mList);
		return "memberList";
	}
	
	@RequestMapping(value="getMember/{userid}", method=RequestMethod.GET)
	public String getMember(@PathVariable("userid") String userid, Model model) throws Exception {
		MemberVO member = memberService.getMember(userid);
		model.addAttribute("member", member);
		return "getMember";
	}
	
}