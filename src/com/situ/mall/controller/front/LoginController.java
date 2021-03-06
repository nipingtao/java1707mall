package com.situ.mall.controller.front;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.sym.Name;
import com.situ.mall.common.ServerResponse;
import com.situ.mall.pojo.Category;
import com.situ.mall.pojo.Product;
import com.situ.mall.pojo.User;
import com.situ.mall.service.ICategoryService;
import com.situ.mall.service.IProductService;
import com.situ.mall.service.IUserService;


import sun.security.util.Password;



@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private IUserService userService;

	
	@RequestMapping(value = "/login")
	private ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value = "/register")
	private ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	@RequestMapping(value = "/add")
	private String add(User user) {
		System.out.println("*************************************"+user);
		userService.add(user);
		return "redirect:/login/login.shtml";
	}
	@RequestMapping(value = "/dd")
	@ResponseBody
	protected ServerResponse  dd(Model model, HttpServletRequest req,String username,String password){
		User user =	userService.findByNameAndPassword(username,password);
		if (user != null) {
			/*model.addAttribute("user", user);*/
			HttpSession session = req.getSession(true);
			session.setAttribute("user", user);
			return ServerResponse.createSuccess("登录成功");
		} else {
			//登陆失败
			return ServerResponse.createError("登录失败");
		}
	}
	@RequestMapping(value = "/fenlei")
	private ModelAndView fenlei(int CategoryId) {
		List<Product> list = productService.find(CategoryId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("fenlei");
		return modelAndView;
	}

}
