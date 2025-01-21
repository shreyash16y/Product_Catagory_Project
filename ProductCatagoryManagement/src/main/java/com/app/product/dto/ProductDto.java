package com.app.product.dto;

import com.app.product.model.Product;

public class ProductDto {
	private int productId;
	private String productName;
	private double price;
	private int categoryId;
	private String categoryName;
	
	public ProductDto(Product product) 
	{
		this.productId=product.getProductId();
		this.productName=product.getProductName();
		this.price=product.getPrice();
		this.categoryId=product.getCategory().getCategoryId();
		this.categoryName=product.getCategory().getCategoryName();
	}

	public int getProductId()
	{
		return productId;
	}

	public void setProductId(int productId) 
	{
		this.productId = productId;
	}

	public String getProductName() 
	{
		return productName;
	}

	public void setProductName(String productName) 
	{
		this.productName = productName;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price) 
	{
		this.price = price;
	}

	public int getCategoryId() 
	{
		return categoryId;
	}

	public void setCategoryId(int categoryId) 
	{
		this.categoryId = categoryId;
	}

	public String getCategoryName() 
	{
		return categoryName;
	}

	public void setCategoryName(String categoryName) 
	{
		this.categoryName = categoryName;
	}
}
