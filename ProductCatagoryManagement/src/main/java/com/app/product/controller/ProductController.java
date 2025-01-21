package com.app.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.product.dto.ProductDto;
import com.app.product.model.Product;
import com.app.product.service.ProductService;

@RestController
public class ProductController 
{
	@Autowired
	ProductService productService;
	
	@PostMapping("/api/products")
	public ResponseEntity<Product> addNewProduct(@RequestBody Product p)
	{
		Product prod= productService.addProduct(p);
		return new ResponseEntity<Product>(prod,HttpStatus.ACCEPTED);
	}
	@GetMapping("/api/products")
	public ResponseEntity<ProductDto> getProductById(@RequestParam int page)
	{
		Product prod= productService.getProduct(page);
		ProductDto dto= new ProductDto(prod);
		return new ResponseEntity<ProductDto>(dto,HttpStatus.OK);
	}
	
	@GetMapping("/api/products/{productId}")
	public ResponseEntity<ProductDto> getProductByUsingProductId(@PathVariable int productId)
	{
		Product prod= productService.getProductByUsingProductId(productId);
		ProductDto dto =new ProductDto(prod);
		return new ResponseEntity<ProductDto>(dto,HttpStatus.OK);
	}
	
	@PutMapping("/api/products/{productId}")
	public ResponseEntity<Product> updateProductById(@PathVariable int productId,@RequestBody Product p)
	{
		Product prod= productService.updateProduct(productId,p);
		return new ResponseEntity<Product>(prod,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/api/products/{productId}")
	public ResponseEntity<String> deleteProductByUsingProductId(@PathVariable int productId)
	{
		productService.deleteProductId(productId);
		return new ResponseEntity<String>("Product delete successfully!!!",HttpStatus.OK);
	}
}
