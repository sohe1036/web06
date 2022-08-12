package com.company.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.company.shop.service.BoardService;
import com.company.shop.vo.BoardVO;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("list.do")
	public ModelAndView selectListBoard() throws Exception {
		ModelAndView mav = new ModelAndView("boardList");
		List<BoardVO> bList = boardService.selectListBoard();
		mav.addObject("bList", bList);
		return mav;
	}
	
	@RequestMapping(value="getBoard/{bno}", method=RequestMethod.GET)
	public String getBoard(@PathVariable("bno") int bno, ModelMap model) throws Exception {
		BoardVO board = boardService.getBoard(bno);
		model.addAttribute("board", board);
		return "getBoard";
	}
	
	@RequestMapping("addBoardForm.do")
	public ModelAndView addBoardForm() {
		ModelAndView mav = new ModelAndView("addBoardForm");
		//데이터바인딩
		mav.addObject("board", new BoardVO());
		return mav;
	}
	
	@RequestMapping(value="addBoardPro.do",method=RequestMethod.POST)
	public String addBoardPro(@ModelAttribute("board") BoardVO boardVO) throws Exception {
		boardService.addBoard(boardVO);
		return "redirect:list.do";
	}

}
