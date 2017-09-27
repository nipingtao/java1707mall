package com.situ.mall.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.situ.mall.pojo.Product;
import com.situ.mall.service.IProductService;




@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@RequestMapping("/findAll")
	public String findAll(Model model) {
		List<Product> list = productService.findAll();
		model.addAttribute("list", list);
		return "product";
	}
	
	
	@RequestMapping("/deletById")
	public String deletById(int id) {
		productService.deletById(id);
		return "redirect:/product/findAll.action";
	}
	  @RequestMapping(value="/update")
			private ModelAndView update( String id){
		 Product product = productService.findById(Integer.parseInt(id));
				ModelAndView modelAndView = new ModelAndView();
				modelAndView.addObject("product",product);
				modelAndView.setViewName("product_update");
				return modelAndView;
			}
	  @RequestMapping(value="/updateProduct")
		private String updateProduct(Product product){
		       productService.update(product);
			  return "redirect:/product/findAll.action";
		}
	     @RequestMapping(value="/getAddPage")
		 	private ModelAndView getAddPage(Product product){
		 		ModelAndView modelAndView = new ModelAndView();
		 		modelAndView.setViewName("product_addproduct");
		 		return modelAndView;
		 	}
	

}
