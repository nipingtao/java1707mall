package com.situ.mall.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.situ.mall.constant.MallConstant;
import com.situ.mall.util.JsonUtils;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@RequestMapping(value="/uploadPic")
	@ResponseBody
	public Map<String, Object> uploadPic(MultipartFile pictureFile) {
		System.out.println("UploadController.uploadPic()");
		//为了防止重名生成一个随机的名字:aa4fb86a7896458a8c5b34c634011ae3
		String name = UUID.randomUUID().toString().replace("-", "");
		//jpg,png
		String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
		String fileName = name + "." + ext;
		String filePath = "E:\\pic\\" + fileName;
		try {
			pictureFile.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fileName", fileName);
		map.put("url", filePath);
		return map;
	}
	@RequestMapping(value="/pic", produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	@ResponseBody
	public String uploadFile(MultipartFile pictureFile) {
		try {
			//为了防止重名生成一个随机的名字:aa4fb86a7896458a8c5b34c634011ae3
			String name = UUID.randomUUID().toString().replace("-", "");
			//jpg,png
			String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
			String fileName = name + "." + ext;
			String filePath = MallConstant.SERVER_ADDRES + fileName;
			try {
				pictureFile.transferTo(new File(filePath));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//封装到map中返回
			Map result = new HashMap<>();
			result.put("error", 0);
			result.put("url", filePath);
			//将object转换成json
			return JsonUtils.objectToJson(result);
		} catch (Exception e) {
			e.printStackTrace();
			Map result = new HashMap<>();
			result.put("error", 1);
			result.put("message", "图片上传失败");
			return JsonUtils.objectToJson(result);
		}
	}
	}
	




