package com.situ.mall.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.mall.pojo.Category;
import com.situ.mall.service.ICategoryService;

@Controller
public class IndexController {
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping("/index.shtml")
	public String index(Model model ) {
		List<Category> list = categoryService.findParentCategory();
		List<Category> list1 =  categoryService.findAll();
		model.addAttribute("list", list);
		model.addAttribute("list1", list1);
		return "index";
	}

	// 商品身体
	/*@RequestMapping(value = "/list.shtml")
	public String productMain() {

		
	}*/

}
