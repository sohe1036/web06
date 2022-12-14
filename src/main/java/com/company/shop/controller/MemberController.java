
package com.company.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.shop.service.MemberService;
import com.company.shop.vo.MemberVO;

@Controller
@RequestMapping("/member/")
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@Autowired
	HttpSession session;
	
	
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
	//?????????????????????
	@GetMapping(value="joinForm.do")
	public String joinForm(Model model) throws Exception{
		model.addAttribute("member", new MemberVO());
		return "joinForm";
	}
	//??????????????????
	@RequestMapping(value="addMember.do", method=RequestMethod.POST)
	public String addMember(MemberVO memberVO, Model model) throws Exception {
		memberService.addMember(memberVO);
		return "redirect:loginForm.do";
	}
	//???????????????
	@RequestMapping(value="checkId.do", method=RequestMethod.GET)
	public String checkId(@RequestParam String userid,Model model ,RedirectAttributes attr) throws Exception {
		int cnt = memberService.checkId(userid);
		if(cnt==0) {
			attr.addFlashAttribute("msg", "??????????????? ??????????????????.");
			model.addAttribute("ck", "yes");
		} else {
			attr.addFlashAttribute("msg", "?????? ???????????? ??????????????????.");
			model.addAttribute("ck", null);
		}
		return "joinForm";
	}
	//??????????????????
	@GetMapping(value="loginForm.do")
	public String loginForm(Model model) throws Exception{
		model.addAttribute("member", new MemberVO());
		return "loginForm";
	}
	//???????????????
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String login(@RequestParam String userid, @RequestParam String pwd,RedirectAttributes attr ) throws Exception {
		MemberVO member = new MemberVO();
		member.setUserid(userid);
		member.setPwd(pwd);
		MemberVO login = memberService.login(userid);

		if(login==null) {
			attr.addFlashAttribute("msg", "???????????? ???????????? ????????????.");
			return "loginFail";
		} else if(login!=null&&member.getPwd().equals(pwd)) {
			session.setAttribute("member", login);
			session.setAttribute("sid", member.getUserid());
			return "redirect:/";
		} else {
			attr.addFlashAttribute("msg", "??????????????? ??????????????????.");
			session.setAttribute("member", null);
			session.setAttribute("sid", null);
			return "loginFail";
		}
	
	}
	
	
}