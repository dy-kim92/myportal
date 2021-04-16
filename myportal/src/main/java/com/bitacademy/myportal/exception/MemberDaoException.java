package com.bitacademy.myportal.exception;

import com.bitacademy.myportal.vo.MemberVo;

//	MemberDao 에서의 예외 처리를 위한 클래스
public class MemberDaoException extends RuntimeException {
	
	private MemberVo memberVo = null;
	
	//	생성자
	public MemberDaoException() {
	}
	
	public MemberDaoException(String message) {
		super(message);
	}
	
	public MemberDaoException(String message, MemberVo memberVo) {
		super(message);
		this.memberVo = memberVo;
	}

	//	Getter / Setter
	public MemberVo getMemberVo() {
		return memberVo;
	}

	public void setMemberVo(MemberVo memberVo) {
		this.memberVo = memberVo;
	}

	//	toString
	@Override
	public String toString() {
		return "MemberDaoException [memberVo=" + memberVo + "]";
	}
	
}
