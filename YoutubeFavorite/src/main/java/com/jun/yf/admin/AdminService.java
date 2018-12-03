package com.jun.yf.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jun.yf.admin.dao.AdminMapper;
import com.jun.yf.commons.ImgUtils;
import com.jun.yf.model.GalleryVO;
import com.jun.yf.model.UserVO;
import com.jun.yf.model.YoutubeVO;

@Service
public class AdminService {

	@Autowired
	private AdminMapper mapper;

	@Autowired
	private BCryptPasswordEncoder bpe;

	public void join(UserVO vo) {

		// TODO 비밀번호 암호화
		String encodePassword = bpe.encode(vo.getU_pw());
		vo.setU_pw(encodePassword);

		mapper.join(vo);
	}

	public void inserURL(YoutubeVO vo) {

		mapper.insertURL(vo);
	}

	public void insertGallery(GalleryVO vo) {

		/*
		 * int year, month, day; Calendar calendar = new
		 * GregorianCalendar(Locale.KOREA); year = calendar.get(Calendar.YEAR); month =
		 * calendar.get(Calendar.MONTH)+1; day = calendar.get(Calendar.DAY_OF_MONTH);
		 */
		
		String g_path = ImgUtils.saveImgAndMakeThumb(this.getClass(), vo);
		vo.setG_path(g_path);
		System.out.println("g_path : " + g_path);
		
		mapper.insertGallery(vo);
	}
}
