package com.jun.yf.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jun.yf.model.GalleryVO;
import com.jun.yf.model.UserVO;
import com.jun.yf.model.YoutubeVO;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@RequestMapping("loginForm")
	public String loginForm() {
		return "admin/loginForm";
	}
	
	@RequestMapping("main")
	public String main() {
		return "admin/main";
	}
	
	@RequestMapping("accessDenied")
	public String accessDenied() {
		return "admin/accessDenied";
	}
	
	@RequestMapping("join")
	public String joinGet() {
		return "admin/join";
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String joinPost(UserVO vo) {
		
		service.join(vo);
		return "redirect:loginForm";
	}
	
	@RequestMapping("insertURL")
	public String insertURLGet() {
		return "admin/insertURL";
	}
	
	@RequestMapping(value="insertURL", method=RequestMethod.POST)
	public String insertURLPost(YoutubeVO vo) {
		//TODO insert 수행
		
		service.inserURL(vo);
		return "redirect:main";
	}
	
	@RequestMapping("insertGallery")
	public String insertGalleryGet() {
		return "admin/insertGallery";
	}
	@RequestMapping(value="insertGallery", method=RequestMethod.POST)
	public String insertGalleryPost(GalleryVO vo) {
		service.insertGallery(vo);
		return "admin/insertGallery";
	}
}
