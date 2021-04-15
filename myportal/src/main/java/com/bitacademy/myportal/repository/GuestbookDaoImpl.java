package com.bitacademy.myportal.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.myportal.vo.GuestbookVo;

//@Repository("guestbookDao")
@Repository		//	이름을 명시하지 않으면 클래스 이름을 기반으로 자동으로 명명된다
//	-> guestbookDaoImpl 이름을 bean 이 등록한다
public class GuestbookDaoImpl implements GuestbookDao {

	//	데이터 소스 연결
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<GuestbookVo> selectAll() {

		//	TODO : 예외 전환 처리
		List<GuestbookVo> list = sqlSession.selectList("guestbook.selectAll");
		System.out.println("방명록 : " + list);
		
		return list;
	}

	@Override
	public int insert(GuestbookVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(GuestbookVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
