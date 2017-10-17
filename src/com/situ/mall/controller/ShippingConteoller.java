package com.situ.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.situ.mall.pojo.Product;
import com.situ.mall.pojo.Shipping;
import com.situ.mall.service.IShippingService;
import com.situ.mall.vo.PageBean;

@Controller
@RequestMapping("/shipping")
public class ShippingConteoller {
  @Autowired
  private IShippingService shippingservice;
  
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
		PageBean pageBean = (PageBean) shippingservice.getPageBean(pageIndex, pageSize);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pageBean", pageBean);
		modelAndView.setViewName("shipping_show");
		return modelAndView;
	}
	//添加
	@RequestMapping(value = "/getAddPage")
	private ModelAndView getAddPage(Shipping shipping) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("shipping_addshipping");
		return modelAndView;
	}
	//删除
	@RequestMapping(value="/deletById")
	private String deletById(int id){
		shippingservice.deletById(id);
		return "redirect:/shipping/findPageBeanList.action";
		
	}
	@RequestMapping(value = "/AddShippingService")
	private String AddShippingService(Shipping shipping) {
		System.out.println(shipping);
		shippingservice.add(shipping);
		return "redirect:/shipping/findPageBeanList.action";
	}
 
  

}
