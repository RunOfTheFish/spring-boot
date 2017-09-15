package com.example.three.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * Created by admin on 2017/9/13.
 */
@Service
public class FileService {

	public String saveImage(MultipartFile file) {
		// 判断文件是否为空
		if (!file.isEmpty()) {
			try {
				String lastName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
				String fileName = UUID.randomUUID().toString() + "." + lastName;
				// 文件保存路径
				String filePath = "G:\\my_product\\file\\image\\" + fileName;
				// 转存文件
				file.transferTo(new File(filePath));

				return "http://localhost:8383/" + fileName;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
