package com.company.shop.service;

import java.util.List;

import com.company.shop.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> selectListBoard() throws Exception;
	
	public BoardVO getBoard (int bno) throws Exception;
	
	public void addBoard(BoardVO boardVO) throws Exception;
	
	public void updateBoard(BoardVO boardVO) throws Exception;
	
	public void deleteBoard(int bno) throws Exception;
}
