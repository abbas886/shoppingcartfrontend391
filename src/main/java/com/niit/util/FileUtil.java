package com.niit.util;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component // will create singleton instance and the instance name is fileUtil
public class FileUtil {
	
	@Autowired
	private  HttpSession httpSession;
	

	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

	//private static final String imageDirectory = "ShoppingCartImages";
	//private static String rootPath = System.getProperty("catalina.home");
  //  private static String rootPath = "C:\\Users\\Abbas\\eclipse-workspace\\Temp\\ShoppingCart\\src\\main\\webapp\\resources\\images";
	  private static String rootPath = System.getProperty("user.dir");
	public  boolean fileCopyNIO(MultipartFile file,String fileName) {
System.out.println(rootPath);
		File dest = new File(rootPath+File.separator  + fileName);
		System.out.println("where it is uploading ??"+ dest.getAbsolutePath());
		/*if (!dest.exists()) {
			dest.mkdir();
		}*/

		try {
			file.transferTo(dest);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}
