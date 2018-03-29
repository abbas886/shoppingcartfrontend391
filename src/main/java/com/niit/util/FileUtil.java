package com.niit.util;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

	private static final String imageDirectory = "ShoppingCartImages";
	private static String rootPath = System.getProperty("catalina.home");

	public static boolean fileCopyNIO(MultipartFile file, String fileName) {

		File dest = new File(rootPath + File.separator + imageDirectory + File.separator + fileName);

		if (!dest.exists()) {
			dest.mkdir();
		}

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
