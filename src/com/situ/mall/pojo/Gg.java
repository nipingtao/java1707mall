package com.situ.mall.pojo;

public class Gg {
	private Integer id;

    private String mainImage;
    
    

	public Gg() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Gg(Integer id, String mainImage) {
		super();
		this.id = id;
		this.mainImage = mainImage;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getMainImage() {
		return mainImage;
	}



	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}



	@Override
	public String toString() {
		return "Gg [id=" + id + ", mainImage=" + mainImage + "]";
	}
	
	
    
}
