package com.app.product.service;

import com.app.product.model.Product;

public interface ProductService 
{

	public Product addProduct(Product p);

	public Product getProduct(int productId);

	public Product getProductByUsingProductId(int productId);

	public Product updateProduct(int productId, Product p);

	public void deleteProductId(int productId);

}
