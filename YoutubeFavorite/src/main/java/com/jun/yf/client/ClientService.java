package com.jun.yf.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.yf.client.dao.ClientMapper;
import com.jun.yf.model.GalleryVO;
import com.jun.yf.model.YoutubeVO;

@Service
public class ClientService {
	
	@Autowired
	private ClientMapper mapper;
	
	public List<YoutubeVO> getList(){
		
		return mapper.getList();
	}
	
	public List<GalleryVO> imgGetList(){
		
		return mapper.imgGetList();
	}
	
	public GalleryVO getDetail(int g_no) {
		
		return mapper.getDetail(g_no);
	}
}
