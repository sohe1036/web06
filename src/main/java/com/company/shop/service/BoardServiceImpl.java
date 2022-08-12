package com.company.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.shop.dao.BoardDAO;
import com.company.shop.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAO boardDAO;

	@Override
	public List<BoardVO> selectListBoard() throws Exception {
		return boardDAO.selectListBoard();
	}

	@Override
	public BoardVO getBoard(int bno) throws Exception {
		return boardDAO.getBoard(bno);
	}

	@Override
	public void addBoard(BoardVO boardVO) throws Exception {
		boardDAO.addBoard(boardVO);
	}

	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		boardDAO.updateBoard(boardVO);
	}

	@Override
	public void deleteBoard(int bno) throws Exception {
		boardDAO.deleteBoard(bno);
	}

	
}
