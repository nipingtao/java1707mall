package com.situ.mall.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
      
	private Integer id;

    private Integer categoryId;

    private String name;

    private String subtitle;

    private String mainImage;

    private String subImages;

    private String detail;

    private BigDecimal price;

    private Integer stock;

    private Integer status;

    private Date createTime;

    private Date updateTime;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Product(Integer id, String name, String subtitle, BigDecimal price, Integer stock, Integer status,
			Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.name = name;
		this.subtitle = subtitle;
		this.price = price;
		this.stock = stock;
		this.status = status;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}


	public Product(Integer id, Integer categoryId, String name, String subtitle, String mainImage, String subImages,
			String detail, BigDecimal price, Integer stock, Integer status, Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.subtitle = subtitle;
		this.mainImage = mainImage;
		this.subImages = subImages;
		this.detail = detail;
		this.price = price;
		this.stock = stock;
		this.status = status;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	public String getSubImages() {
		return subImages;
	}

	public void setSubImages(String subImages) {
		this.subImages = subImages;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", categoryId=" + categoryId + ", name=" + name + ", subtitle=" + subtitle
				+ ", mainImage=" + mainImage + ", subImages=" + subImages + ", detail=" + detail + ", price=" + price
				+ ", stock=" + stock + ", status=" + status + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}
    
    
    
}
