package com.jun.yf.client.dao;

import java.util.List;

import com.jun.yf.model.GalleryVO;
import com.jun.yf.model.YoutubeVO;

public interface ClientMapper {

	public List<YoutubeVO> getList();
	
	public List<GalleryVO> imgGetList();
	
	public GalleryVO getDetail(int g_no);
}
