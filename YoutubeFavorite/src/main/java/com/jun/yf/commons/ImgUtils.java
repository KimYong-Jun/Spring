package com.jun.yf.commons;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

import com.jun.yf.model.GalleryVO;

public class ImgUtils {

	public static String saveImgAndMakeThumb(Class<?> cls, GalleryVO vo) {
		
		String g_path = "";
		try {
			String contextPath = cls.getClassLoader().getResource("").getPath();
			String fullPath = URLDecoder.decode(contextPath, "UTF-8");
			String pathArr[] = fullPath.split("WEB-INF/classes/");
			String targetPath = pathArr[0] + "resources/img/";
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String bigImgPath = targetPath + sdf.format(d);
			System.out.println("contextPath : " + bigImgPath);
			
			File path = new File(bigImgPath);
			if(!path.exists()) {
				path.mkdirs();
			}
			UUID uuid = UUID.randomUUID();
			String originFileName = vo.getImg().getOriginalFilename();
			String ext = originFileName.substring(originFileName.lastIndexOf(".") + 1);
			String fileName = uuid.toString() + "." + ext;
			File img = new File(bigImgPath, fileName.toLowerCase());
			FileCopyUtils.copy(vo.getImg().getBytes(), img);
			
			//썸네일 경로 생성
			String thumbImgPath = targetPath + "/thumb/" + sdf.format(d);
			path = new File(thumbImgPath);			
			if(!path.exists()) {
				path.mkdirs();
			}
			
			//썸네일 생성
			BufferedImage sourceImg = ImageIO.read(img);
			BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
			File thumbImg = new File(thumbImgPath, fileName.toLowerCase());
			ImageIO.write(destImg, ext.toLowerCase(), thumbImg);
			
			g_path = sdf.format(d) + "/" + fileName;
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return g_path;
}
}