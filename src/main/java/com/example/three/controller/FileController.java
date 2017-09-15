package com.example.three.controller;

import com.example.three.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by admin on 2017/9/13.
 */
@RestController
@RequestMapping(value = "file")
public class FileController {

	@Autowired
	private FileService fileService;

	@RequestMapping(value = "image")
	public String image(MultipartFile file) {
		return fileService.saveImage(file);
	}

}
