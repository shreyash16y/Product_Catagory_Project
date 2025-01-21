package com.app.product.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.product.model.Product;
import com.app.product.repository.ProductRepository;
import com.app.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService 
{
	@Autowired
	ProductRepository productrepo;

	@Override
	public Product addProduct(Product p) 
	{
		return productrepo.save(p);
	}

	@Override
	public Product getProduct(int productId) 
	{
		Optional<Product> prod = productrepo.findById(productId);
		if (prod.isPresent()) 
		{
			return prod.get();
		}
		return null;
	}

	@Override
	public Product getProductByUsingProductId(int productId) 
	{
		Optional<Product> prod = productrepo.findById(productId);
		if (prod.isPresent()) 
		{
			return prod.get();
		}
		return null;
	}

	@Override
	public Product updateProduct(int productId, Product p) 
	{
		Optional<Product> prod= productrepo.findById(productId);
		if(prod.isPresent()) {
			prod.get().setProductId(p.getProductId());
			prod.get().setProductName(p.getProductName());
			prod.get().setPrice(p.getPrice());
			productrepo.save(prod.get());
		}
		return p;
	}

	@Override
	public void deleteProductId(int productId)
	{
		productrepo.deleteById(productId);
		
	}
}
