package com.app.catagory.controller;

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

import com.app.catagory.model.Catagories;
import com.app.catagory.service.CatagoryService;
import com.app.product.model.Product;
import com.app.product.service.ProductService;

@RestController
public class CategoryController 
{
	@Autowired
	CatagoryService catagoryService;

	@PostMapping("/api/categories")
	public ResponseEntity<Catagories> addCatagories(@RequestBody Catagories c) 
	{
		Catagories cat = catagoryService.addCatagories(c);
		return new ResponseEntity<Catagories>(cat, HttpStatus.ACCEPTED);
	}

	@GetMapping("/api/categories")
	public ResponseEntity<Catagories> getCatagoriesById(@RequestParam int page) 
	{
		Catagories cat = catagoryService.getCatagories(page);
		return new ResponseEntity<Catagories>(cat, HttpStatus.OK);
	}

	@GetMapping("/api/categories/{categoriesid}")
	public ResponseEntity<Catagories> getProductByUsingProductId(@PathVariable int categoriesid) 
	{
		Catagories cat = catagoryService.getCatagories(categoriesid);
		return new ResponseEntity<Catagories>(cat, HttpStatus.OK);
	}

	@PutMapping("/api/categories/{categoryId}")
	public ResponseEntity<Catagories> updateCategory(@PathVariable int categoryId, @RequestBody Catagories c) 
	{
		Catagories cat = catagoryService.updateCategoryById(categoryId, c);
		return new ResponseEntity<Catagories>(cat, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/api/categories/{categoryId}")
	public ResponseEntity<String> deleteCategoryByUsingId(@PathVariable int categoryId) 
	{
		catagoryService.deleteCategory(categoryId);
		return new ResponseEntity<String>("Category delete successfully!!!", HttpStatus.OK);
	}

}
