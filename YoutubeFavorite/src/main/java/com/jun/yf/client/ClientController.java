package com.jun.yf.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jun.yf.model.GalleryVO;
import com.jun.yf.model.YoutubeVO;

@Controller
@RequestMapping("client")
public class ClientController {
	
	@Autowired
	private ClientService service;

	@RequestMapping("list")
	public String list(Model model) {
		
		List<YoutubeVO> list = service.getList();
		
		model.addAttribute("list", list);
		
		return "client/list";
	}
	
	@RequestMapping("galleryList")
	public String galleryList(Model model) {
		
		List<GalleryVO> list = service.imgGetList();
		
		model.addAttribute("list", list);
		
		return "client/galleryList";
	}
	
	@RequestMapping("galleryDetail")
	public String galleryDetail(@RequestParam(name="g_no") int g_no, Model model) {
		
		GalleryVO vo = service.getDetail(g_no);
		model.addAttribute("vo", vo);
		return "client/galleryDetail";
	}
}
