package com.example.demo.controller;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDAO;
import com.example.demo.vo.BoardVO;

import lombok.Setter;

@Controller
@Setter
public class BoardController {
	
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("/listBoard")
	public void list(Model model) {
		model.addAttribute("list", dao.list());
	}
	
	@RequestMapping(value = "/insertBoard", method = RequestMethod.GET)
	public void insertForm( Model model, @RequestParam(value = "no", defaultValue = "0") int no) {
		model.addAttribute("no", no);
		String head = "새글작성";
		String title = "";
		if(no != 0) {
			head = "답글작성";
			title = "답글)"+ dao.findByNo(no).getTitle();
		}
		model.addAttribute("head", head);
		model.addAttribute("title", title);
	}
	
	@RequestMapping(value = "/insertBoard", method = RequestMethod.POST)
	public ModelAndView insertSubmit(BoardVO b, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard");
		MultipartFile uploadFile = b.getUploadFile();
		String fname = uploadFile.getOriginalFilename();	
		byte []data = null;
		try {
			data = uploadFile.getBytes();	
			if(data != null && data.length != 0) {
				b.setFname(fname);
				b.setFsize(data.length);
			}else {
				b.setFname("");
				b.setFsize(0);
			}
		
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		//일단 새글이라고 보자
		int no = dao.getNextNo();
		int b_ref = no;
		int b_step = 0;
		int b_level = 0;
		
		//만약에 답글이라면
		int pno = b.getNo();
		if(pno != 0) {
			BoardVO p= dao.findByNo(pno);
			b_ref  = p.getB_ref();
			b_step = p.getB_step();
			b_level = p.getB_level();
			
			dao.updateStep(b_ref, b_step);
			b_level++;
			b_step++;
		}
		
		b.setNo(no);
		b.setB_ref(b_ref);
		b.setB_step(b_step);
		b.setB_level(b_level);
		b.setIp(request.getRemoteAddr());
		
		int re = dao.insert(b);
		if(re == 1) {
			if(b.getFsize() != 0) {
				String path = request.getRealPath("upload");
				System.out.println("path:"+path);
				try {
					FileOutputStream fos = new FileOutputStream(path + "/" +fname);
					fos.write(data);
					fos.close();
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}else {
			mav.setViewName("error");
			mav.addObject("msg", "게시물 등록에 실패하였습니다.");
		}
		
		return mav;
	}
	
	
	@RequestMapping("/detailBoard")
	public void detail(int no, Model model) {
		model.addAttribute("b", dao.findByNo(no));
	}
}















