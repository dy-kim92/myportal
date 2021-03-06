package com.bitacademy.myportal.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.myportal.repository.GuestbookDaoImpl;
import com.bitacademy.myportal.service.GuestbookService;
import com.bitacademy.myportal.vo.GuestbookVo;

@RequestMapping("/guestbook")
@Controller
public class GuestbookController {

	//	로거 설정
	private static Logger logger = LoggerFactory.getLogger(GuestbookDaoImpl.class);
	
	//	서비스 연결
	@Autowired
	GuestbookService guestbookServiceImpl;
	
//	@ResponseBody
	@RequestMapping({"", "/", "list"})
	//	->	/guestbook, /guestbook/, /guestbook/list
	
	public String list(Model model) {
		
		List<GuestbookVo> list = guestbookServiceImpl.getList();
		
		//	데이터를 모델에 추가
		model.addAttribute("list", list);
		
		return "guestbook/list";
	}
	
	
	//	게시물 작성 메소드	- 클래스 매핑이 /guestbook 이어서 뒤에 하위부분만 작성해주면 됨
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@ModelAttribute GuestbookVo vo) {
		
//		System.out.println("VO : " + vo);
		logger.debug("VO : " + vo);
		boolean success = guestbookServiceImpl.writeMessage(vo);
//		System.out.println("Write Result : " + success);
		logger.debug("Write Result : " + success);
		
		//	리스트 페이지로 리다이렉트
		return "redirect:/guestbook";
		
	}
	
	
	//	게시물 삭제 폼
	@RequestMapping(value="/delete/{no}", method=RequestMethod.GET)	//	Path Variable
	public String deleteForm(@PathVariable Long no, Model model) {
		
		model.addAttribute("no", no);
		return "guestbook/deleteform";
	}
	
	//	게시물 삭제 기능
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@ModelAttribute GuestbookVo vo) {
		boolean success = guestbookServiceImpl.deleteMessage(vo);
//		System.out.println("Delete Result : " + success);
		logger.debug("Delete Result : " + success);
		
		//	리다이렉트
		return "redirect:/guestbook";
	}
	
}
