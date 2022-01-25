package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDAO;
import com.example.demo.vo.BoardVO;

import lombok.Data;
import lombok.Setter;

@Controller
@Setter
public class BoardController {
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("/listBoard")
	public void list(Model model) {
		model.addAttribute("list", dao.findAll());
	}
	
	@RequestMapping(value = "/insertBoard", method = RequestMethod.GET)
	public void insertForm() {		
	}
	
	@RequestMapping(value = "/insertBoard", method = RequestMethod.POST)
	public ModelAndView insertSubmit(BoardVO b, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard");
		String path = request.getRealPath("upload");
		System.out.println("path:"+path);
		b.setFname("");
		MultipartFile uploadFile = b.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		if(fname != null && !fname.equals("")) {
			b.setFname(fname);
		}	
		
		int re = dao.insert(b);
		if(re != 1) {
			mav.setViewName("error");
			mav.addObject("msg", "상품등록에 실패하였습니다.");
		}else {
			try {
				byte []data = uploadFile.getBytes();
				if(fname != null && !fname.equals("")) {
					FileOutputStream fos = new FileOutputStream(path + "/"+fname);
					fos.write(data);
					fos.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}	
		}
		
		return mav;
	}
	
	@RequestMapping("/detailBoard")
	public void detail(int no, Model model) {
		model.addAttribute("b", dao.findByNo(no));
	}
	
	@RequestMapping(value = "/updateBoard", method = RequestMethod.GET)
	public void updateForm(int no, Model model) {
		model.addAttribute("b", dao.findByNo(no));
	}
	
	@RequestMapping(value = "/updateBoard", method = RequestMethod.POST)
	public ModelAndView updateSubmit(BoardVO b, HttpServletRequest request) {
		
		String path = request.getRealPath("upload");
		ModelAndView mav = new ModelAndView("redirect:/listBoard");
		String oldFname = b.getFname();
		MultipartFile uploadFile = b.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		if(fname != null && !fname.equals("")) {
			b.setFname(fname);
		}
		int re = dao.update(b);
		if(re == 1) {
			//게시물 수정에 성공했고, 또 첨부파일도 수정했다면
			//파일복사를 해 줍니다.
			if(fname != null && !fname.equals("")) {
				try {
					byte []data = uploadFile.getBytes();
					FileOutputStream fos = new FileOutputStream(path + "/" + fname);
					fos.write(data);
					fos.close();
					
					//원래게시물이 첨부파일이 있었다면 원래파일을 삭제합니다.
					if(oldFname != null && !oldFname.equals("")) {
						File file = new File(path + "/" +oldFname);
						file.delete();
					}
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}else {
			
		}
		
		
		return mav;
	}
}











