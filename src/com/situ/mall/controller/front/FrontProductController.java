package com.situ.mall.controller.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.mall.constant.MallConstant;
import com.situ.mall.pojo.Product;
import com.situ.mall.service.IProductService;

@Controller
	@RequestMapping("/product")
	public class FrontProductController {
		@Autowired
		private IProductService productService;
		
		@RequestMapping("/detail.shtml")
		public String getProductDetail(Integer id, Model model) {
			Product product = productService.findById(id);
			model.addAttribute("product", product);
			//按照“，”分割subImages，
			String subImagesStr = product.getSubImages();
			if (null != subImagesStr && !subImagesStr.equals("")) {
				String[] subImages = subImagesStr.split(",");
				for (int i = 0; i < subImages.length; i++) {
					subImages[i] = MallConstant.SERVER_ADDRES + subImages[i];
				}
				//放到域对象中
				model.addAttribute("subImages", subImages);
			}
			return "detail";
		}
		
	}


