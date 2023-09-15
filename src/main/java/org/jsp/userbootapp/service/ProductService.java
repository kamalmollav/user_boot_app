package org.jsp.userbootapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.userbootapp.dao.ProductDao;
import org.jsp.userbootapp.dto.Product;
import org.jsp.userbootapp.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
@Service
public class ProductService {
@Autowired
private ProductDao dao;
	public  ResponseStructure<Product> saveProduct(Product product){
		ResponseStructure<Product> structure=new ResponseStructure<Product>();
		structure.setMessage("Product registered successfully");
		structure.setBody(dao.saveProduct(product));
		structure.setCode(HttpStatus.CREATED.value());
		return structure;
	}
	public  ResponseStructure<Product> updateProduct(Product product){
		ResponseStructure<Product> structure=new ResponseStructure<Product>();
		structure.setMessage("Product updated successfully");
		structure.setBody(dao.saveProduct(product));
		structure.setCode(HttpStatus.ACCEPTED.value());
		return structure;
	}
	public  ResponseStructure<List<Product>> findAll(){
		ResponseStructure<List<Product>> structure=new ResponseStructure<>();
		structure.setBody(dao.findAlL());
		structure.setMessage("all product are displayed");
		structure.setCode(HttpStatus.OK.value());
		return structure;
	}
	public  ResponseStructure<Product> findProduct(int id){
		ResponseStructure<Product> structure=new ResponseStructure<Product>();
		Optional<Product> recProduct=dao.findProduct(id);
		if(recProduct.isPresent()) {
		structure.setBody(recProduct.get());
		structure.setMessage("Product find");
		structure.setCode(HttpStatus.OK.value());
		return structure;
	}
		structure.setBody(null);
		structure.setMessage("Product not found");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return structure;
}
	public  ResponseStructure<String> deleteProduct(int id){
		ResponseStructure<String> structure=new ResponseStructure<>();
		Optional<Product> recProduct=dao.findProduct(id);
		if(recProduct.isPresent()) {
			dao.deleteProduct(id);
		structure.setMessage("Product found");
		structure.setBody("product deleted");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return structure;
	}
		structure.setBody("product not deleted");
		structure.setMessage("Product not found");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		return structure;
}
	
}
