package com.company.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.company.shop.service.BoardService;
import com.company.shop.vo.BoardVO;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("addBoardForm.do")
	public ModelAndView addBoardForm() {
		ModelAndView mav = new ModelAndView("addBoardForm");
		//데이터바인딩
		mav.addObject("board", new BoardVO());
		return mav;
	}

}
