package com.situ.mall.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.situ.mall.pojo.Gg;

import com.situ.mall.service.IGgService;
import com.situ.mall.vo.PageBean;



@Controller
@RequestMapping("/gg")
public class GgController {
	@Autowired
	private IGgService ggService;
	

	@RequestMapping("/deletById")
	public String deletById(int id) {
		ggService.deletById(id);
		return "redirect:/gg/findPageBeanList.action";
	}

	@RequestMapping(value = "/getAddPage")
	private ModelAndView getAddPage(Gg gg) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("gg_addgg");
		return modelAndView;
	}

	@RequestMapping(value = "/findPageBeanList")
	private ModelAndView findPageBeanList(Integer pageIndex, String pageSizeStr) {
		/*
		 * int pageIndexInt = 1;//默认取第一页的数据 if (pageIndex != null &&
		 * !pageIndex.equals("")) { pageIndexInt = Integer.parseInt(pageIndex);
		 * }
		 */
		if (pageIndex == null) {
			pageIndex = 1;
		}
		int pageSize = 5;// 默认每一页数量
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean pageBean = (PageBean) ggService.getPageBean(pageIndex, pageSize);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pageBean", pageBean);
		modelAndView.setViewName("gg");
		return modelAndView;
	}

	@RequestMapping(value = "/AddGgService")
	private String AddGgService(Gg gg) {
		System.out.println(gg);
		ggService.add(gg);
		return "redirect:/gg/findPageBeanList.action";
	}

	@RequestMapping(value = "/deleteAll")
	public String deleteAll(String[] ids) {
		ggService.deleteAll(ids);
		return "redirect:/product/findPageBeanList.action";
	}


}
