package com.bitacademy.myportal.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitacademy.myportal.vo.GuestbookVo;

//@Repository("guestbookDao")
@Repository		//	이름을 명시하지 않으면 클래스 이름을 기반으로 자동으로 명명된다
//	-> guestbookDaoImpl 이름을 bean 이 등록한다
public class GuestbookDaoImpl implements GuestbookDao {
	
	//	로거 설정
	private static Logger logger = LoggerFactory.getLogger(GuestbookDaoImpl.class);

	//	데이터 소스 연결
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<GuestbookVo> selectAll() {
		//	TODO : 예외 전환 처리
		List<GuestbookVo> list = sqlSession.selectList("guestbook.selectAll");
//		System.out.println("방명록 : " + list);
		logger.debug("방명록 : " + list);
		
		return list;
	}

	@Override
	public int insert(GuestbookVo vo) {
		int insertedCount = sqlSession.insert("guestbook.insert", vo);
		return insertedCount;
	}

	@Override
	public int delete(GuestbookVo vo) {
		int deletedCount = sqlSession.delete("guestbook.delete", vo);
		return deletedCount;
	}

}
