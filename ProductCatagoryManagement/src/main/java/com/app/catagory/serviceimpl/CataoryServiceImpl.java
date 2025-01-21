package com.app.catagory.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.catagory.model.Catagories;
import com.app.catagory.repository.CatagoryRepository;
import com.app.catagory.service.CatagoryService;
import com.app.product.model.Product;
import com.app.product.repository.ProductRepository;
import com.app.product.service.ProductService;

@Service
public class CataoryServiceImpl implements CatagoryService 
{
	@Autowired
	CatagoryRepository catagoryRepository;

	
	@Override
	public Catagories addCatagories(Catagories c) 
	{
		return catagoryRepository.save(c);
	}

	@Override
	public Catagories getCatagories(int categoriesid) 
	{
		Optional<Catagories> category = catagoryRepository.findById(categoriesid);
		if (category.isPresent()) 
		{
			return category.get();
		}
		return  null;
	}

	@Override
	public Catagories updateCategoryById(int categoriesid, Catagories c) 
	{
		Optional<Catagories> cat = catagoryRepository.findById(categoriesid);
		if (cat.isPresent()) 
		{
			cat.get().setCategoryName(c.getCategoryName());
			catagoryRepository.save(cat.get());
		}
		return c;
	}

	@Override
	public void deleteCategory(int categoriesid) 
	{
		catagoryRepository.deleteById(categoriesid);
	}
}
