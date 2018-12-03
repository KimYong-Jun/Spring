package com.jun.yf.admin.dao;

import com.jun.yf.model.GalleryVO;
import com.jun.yf.model.UserVO;
import com.jun.yf.model.YoutubeVO;

public interface AdminMapper {
	
	public void join(UserVO p);
	
	public void insertURL(YoutubeVO p);
	
	public void insertGallery(GalleryVO p);
}
