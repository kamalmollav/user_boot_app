package org.jsp.userbootapp.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.jsp.userbootapp.dto.Product;
import org.jsp.userbootapp.dto.ResponseStructure;
import org.jsp.userbootapp.dto.User;
import org.jsp.userbootapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
@Autowired
private ProductService service;

@PostMapping("/products")
public ResponseStructure<Product> saveProduct(@RequestBody Product product){
	return service.saveProduct(product);
}
@PutMapping("/products")
public ResponseStructure<Product>updateProduct(@RequestBody Product product) {
	return service.updateProduct(product);
}

@GetMapping("/users/{id}")
public ResponseStructure<Product>findProduct(@PathVariable int id) {
	return service.findProduct(id);
}

@DeleteMapping("/products/{id}")
public ResponseStructure<String>deleteProduct(@PathVariable int id) {
	return service.deleteProduct(id);
}

@GetMapping("/products")
public ResponseStructure<List<Product>> findAll(){
	return service.findAll();
}

}
