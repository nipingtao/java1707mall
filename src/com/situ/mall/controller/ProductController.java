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
import com.situ.mall.vo.PageBean;






@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@InitBinder
 	protected void initBinder(WebDataBinder binder) {
         binder.registerCustomEditor(Date.class, new CustomDateEditor(
                 new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
         binder.registerCustomEditor(Date.class, new CustomDateEditor(
                 new SimpleDateFormat("yyyy-MM-dd"), true));
     }
	
	@RequestMapping("/findAll")
	public String findAll(Model model) {
		List<Product> list = productService.findAll();
		model.addAttribute("list", list);
		return "product";
	}
	
	
	@RequestMapping("/deletById")
	public String deletById(int id) {
		productService.deletById(id);
		return "redirect:/product/findPageBeanList.action";
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
			  return "redirect:/product/findPageBeanList.action";
		}
	     @RequestMapping(value="/getAddPage")
		 	private ModelAndView getAddPage(Product product){
		 		ModelAndView modelAndView = new ModelAndView();
		 		modelAndView.setViewName("product_addproduct");
		 		return modelAndView;
		 	}
	     @RequestMapping(value="/findPageBeanList")
	 	private ModelAndView findPageBeanList( String pageIndexStr,String pageSizeStr){
	 		int pageIndexInt = 1;//默认取第一页的数据
	 		if (pageIndexStr != null && !pageIndexStr.equals("")) {
	 			pageIndexInt = Integer.parseInt(pageIndexStr);
	 		}
	 		int pageSizeInt = 10;//默认每一页数量
	 		if (pageSizeStr != null && !pageSizeStr.equals("")) {
	 			pageSizeInt = Integer.parseInt(pageSizeStr);
	 		}
	 		PageBean pageBean = (PageBean) productService.getPageBean(pageIndexInt, pageSizeInt);
	 		ModelAndView modelAndView = new ModelAndView();
	 		modelAndView.addObject("pageBean",pageBean);
	 		modelAndView.setViewName("product");
	 		return modelAndView;
	 	}
	     @RequestMapping(value="/AddProductService")
		 	private String AddProductService(Product product)  {
		 	    productService.add(product);
		 		return "redirect:/product/findPageBeanList.action";
		 	}
	     @RequestMapping(value="/deleteAll")
		 	public String deleteAll( String[] ids){
	    	 productService.deleteAll(ids);
		 		return "redirect:/product/findPageBeanList.action";
		 	}
	

}
