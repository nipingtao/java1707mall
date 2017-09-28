package com.situ.mall.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.situ.mall.pojo.Category;
import com.situ.mall.service.ICategoryService;
import com.situ.mall.vo.PageBean;


@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;
	
	@InitBinder
 	protected void initBinder(WebDataBinder binder) {
         binder.registerCustomEditor(Date.class, new CustomDateEditor(
                 new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
         binder.registerCustomEditor(Date.class, new CustomDateEditor(
                 new SimpleDateFormat("yyyy-MM-dd"), true));
     }
	
	
	
	  @RequestMapping(value="/findPageBeanList")
	 	private ModelAndView findPageBeanList( Integer pageIndex, String pageSizeStr){
	 		/*int pageIndexInt = 1;//默认取第一页的数据
	 		if (pageIndex != null && !pageIndex.equals("")) {
	 			pageIndexInt = Integer.parseInt(pageIndex);
	 		}*/
	 		if (pageIndex == null) {
	 			pageIndex = 1;
	 		}
	 		int pageSize = 10;//默认每一页数量
	 		if (pageSizeStr != null && !pageSizeStr.equals("")) {
	 			pageSize = Integer.parseInt(pageSizeStr);
	 		}
	 		PageBean pageBean = (PageBean) categoryService.getPageBean(pageIndex, pageSize);
	 		ModelAndView modelAndView = new ModelAndView();
	 		modelAndView.addObject("pageBean",pageBean);
	 		modelAndView.setViewName("category");
	 		return modelAndView;
	 	}
	  
	  @RequestMapping("/deletById")
		public String deletById(int id) {
		  categoryService.deletById(id);
			return "redirect:/category/findPageBeanList.action";
		}
	  @RequestMapping(value="parenCategoryList")
		@ResponseBody
		public List<Category> parenCategoryList() {
			List<Category> list = categoryService.findParentCategory();
			return list; 
		}
	  @RequestMapping(value="categoryList")
		@ResponseBody
		public List<Category> categoryList(int parentId) {
			List<Category> list =  categoryService.findCategory(parentId);
			return list;
		}
}
