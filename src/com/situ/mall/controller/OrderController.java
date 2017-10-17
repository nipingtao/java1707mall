package com.situ.mall.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.situ.mall.pojo.OrderItem;
import com.situ.mall.service.IOrderItemService;
import com.situ.mall.service.IOrderServiceBack;
import com.situ.mall.vo.PageBean;

@Controller
@RequestMapping("/orderBack")
public class OrderController {
	
	@Autowired
	private IOrderServiceBack orderServiceBack;
	
	@Autowired
	private IOrderItemService orderItemService;
	//查询
	@RequestMapping(value="/findOrderItem")
	public String findOrderItem(Long orderNo, Model model){
		List<OrderItem> list = orderItemService.findOrderItemByorder_no(orderNo);
		
		System.out.println(list);
		model.addAttribute("list", list);
		return "order_show";
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
		PageBean pageBean = (PageBean) orderServiceBack.getPageBean(pageIndex, pageSize);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pageBean", pageBean);
		modelAndView.setViewName("orderItem_show");
		return modelAndView;
	}
	@RequestMapping(value="/deletById")
	private String deletById(int id){
		orderServiceBack.deletById(id);
		return "redirect:/orderBack/findPageBeanList.action";
		
	}

}
