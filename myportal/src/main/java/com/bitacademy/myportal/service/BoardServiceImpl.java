package com.bitacademy.myportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitacademy.myportal.repository.BoardDao;
import com.bitacademy.myportal.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {

	//	Repository 연결
	BoardDao boardDaoImpl; 
	
	@Override
	public List<BoardVo> getList() {
		List<BoardVo> list = boardDaoImpl.selectAll();
		return list;
	}

	@Override
	public boolean write(BoardVo vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BoardVo getContent(Long no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(BoardVo vo) {
		// TODO Auto-generated method stub
		return false;
	}

}
