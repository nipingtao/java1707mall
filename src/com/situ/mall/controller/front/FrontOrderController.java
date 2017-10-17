package com.situ.mall.controller.front;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.situ.mall.pojo.Order;
import com.situ.mall.pojo.OrderItem;
import com.situ.mall.pojo.Product;
import com.situ.mall.pojo.Shipping;
import com.situ.mall.pojo.User;
import com.situ.mall.service.IOrderItemService;
import com.situ.mall.service.IOrderServiceBack;
import com.situ.mall.service.IProductService;
import com.situ.mall.service.IShippingService;
import com.situ.mall.vo.BuyCartVO;
import com.situ.mall.vo.CartItemVO;



@Controller
@RequestMapping(value ="/order")
public class FrontOrderController {
	
	 @Autowired
	    private IShippingService shippingService;
	 @Autowired
	    private IProductService productService;
	 @Autowired
		private IOrderItemService orderItemService;
	 private IShippingService shippingservice;

	@RequestMapping("/settle")
	public String settle(Model model, HttpServletRequest request,Integer productId, Integer amount, 
			 HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			Shipping shipping = shippingService.findByUserId(user.getId());
			System.out.println(shipping);
			model.addAttribute("shipping",shipping);
			
			//springmvc
			ObjectMapper objectMapper = new ObjectMapper();
			//只有对象里面不是null的才转换
			objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			BuyCartVO buyCartVO = null;
			Cookie[] cookies = request.getCookies();
			//1.如果cookie有这个购物车对象，那就从cookie里面取出这个购物车对象
			if (null != cookies && cookies.length > 0) {
				for (Cookie cookie : cookies) {
					if ("buy_cart_cookie".equals(cookie.getName())) {
						//之前已经有购物车
						//"{\"items\":[{\"product\":{\"id\":45},\"amount\":1}],\"productId\":45}"
						String value = cookie.getValue();
						try {
							buyCartVO = objectMapper.readValue(value, BuyCartVO.class);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
			//放到域对象中返回到前端展示的这个购物车，需要将Product对象填满数据才行
			List<CartItemVO> items = buyCartVO.getItems();
			for (CartItemVO item : items) {
				Product product = productService.findById(item.getProduct().getId());
				item.setProduct(product);
			}
			
			model.addAttribute("buyCartVO", buyCartVO);
			
			
			return "order";
		} else {
			return "redirect:/login/login.shtml";
		}
	}
	
	 @RequestMapping("/addOrder")
	 private String addOrder(Order order,HttpServletRequest request, Model model,HttpServletResponse response){
			System.out.println(order);
			//1.获得User对象从Session中
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			Long orderNo = System.currentTimeMillis();//生成订单号
			order.setOrderNo(orderNo);
			System.out.println(order);
			order.setUserId(user.getId());
			//将订单插入数据库
			boolean b = orderItemService.add(order);
			ObjectMapper objectMapper = new ObjectMapper();
			//只有对象中不是空的才转换
			objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			//从cookie中得到购物车
			
				objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
				BuyCartVO buyCartVO = null;
				Cookie[] cookies = request.getCookies();
			//判断cookie是否为空
					if (null != cookies && cookies.length != 0) {
						for (Cookie cookie : cookies) {
							if ("buy_cart_cookie".equals(cookie.getName())) {
								String value = cookie.getValue();
								try {
									buyCartVO = objectMapper.readValue(value, BuyCartVO.class);
								} catch (JsonParseException e) {
									e.printStackTrace();
								} catch (JsonMappingException e) {
									e.printStackTrace();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
					}
					
			if (null != buyCartVO){
				List<CartItemVO> cartItems = buyCartVO.getItems();
				for (CartItemVO cartItemVO : cartItems) {
					OrderItem orderItem = new OrderItem();
					Product product = productService.findById(cartItemVO.getProduct().getId());
					orderItem.setUserId(user.getId());
					orderItem.setOrderNo(orderNo);
					orderItem.setProductId(product.getId());
					orderItem.setProductName(product.getName());
					orderItem.setProductImage(product.getMainImage());
					orderItem.setCurrentUnitPrice(product.getPrice());
					orderItem.setQuantity(cartItemVO.getAmount());
					orderItem.setTotalPrice(new BigDecimal(product.getPrice().intValue() * cartItemVO.getAmount()));;
					orderItemService.addOrderItem(orderItem);
				}
			}
			
			//将订单加入到数据库中后，清除cookie
			Cookie cookie = new Cookie("buy_cart_cookie",null);
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			
			//防止刷新订单，重定向到pay页面
		 
			return "redirect:/order/myorder.shtml";
	 }
	 
	 
	 @RequestMapping("/myorder")
		public String myorder(Model model,HttpServletRequest request){
			System.out.println("FrontOrderController.myorder()");
			//1.获得User对象从Session中
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			List<Object> list = orderItemService.findorderByUser(user.getId());
			model.addAttribute("list", list);
			System.out.println(list);
			return "apy";  
		}
	

}
