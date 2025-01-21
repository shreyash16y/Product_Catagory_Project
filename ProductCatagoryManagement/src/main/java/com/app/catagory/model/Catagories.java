package com.app.catagory.model;

import java.util.List;

import com.app.product.model.Product;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Catagories 
{
	@Id
	private int categoryId;
	private String categoryName;
	
	@OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
	@JsonManagedReference
    private List<Product> products;
	
	public List<Product> getProducts() 
	{
		return products;
	}

	public void setProducts(List<Product> products) 
	{
        this.products = products;
        for (Product product : products) 
        {
            product.setCategory(this);
        }
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