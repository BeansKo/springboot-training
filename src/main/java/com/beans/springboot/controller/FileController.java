package com.beans.springboot.controller;


import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.beans.springboot.domain.JsonData;

@RestController
@PropertySource(value={"classpath:file.properties"})
public class FileController {
	
	@Value("${file.path}")
	String filePath;
	
	@RequestMapping("upload")
	public JsonData uploadFile(@RequestParam("head_img")MultipartFile file, @RequestParam("name") String name) {
		System.out.println("用户名:"+name);
		
		
		String fileName = file.getOriginalFilename();
		System.out.println("上传文件名为："+fileName);
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		fileName = UUID.randomUUID()+suffixName;
		
		File dest = new File(filePath+fileName);
		try {
			file.transferTo(dest);
			return new JsonData(1, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new JsonData(-1, "fail to upload",null);
		
	}
}
