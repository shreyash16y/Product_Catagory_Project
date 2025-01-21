package com.app.catagory.service;

import com.app.catagory.model.Catagories;

public interface CatagoryService 
{

	public Catagories addCatagories(Catagories c);

	public Catagories getCatagories(int categoriesid);

	public Catagories updateCategoryById(int categoriesid, Catagories c);

	public void deleteCategory(int categoriesid);

	
}
