package com.app.product.model;

import com.app.catagory.model.Catagories;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product 
{
	@Id
	private int productId;
	private String productName;
	private double price;
	
	@ManyToOne
    @JoinColumn(name = "category_id")
	@JsonBackReference
    private Catagories category;
	
	public Catagories getCategory() 
	{
		return category;
	}
	public void setCategory(Catagories category) 
	{
		this.category = category;
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
}
