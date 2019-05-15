package com.example.productInfoMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productInfoMS.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductInfoMSController {
	
	@Autowired(required = true)
	@Qualifier("productService")
	ProductService productService;
	
	@RequestMapping("/")
	 public ResponseEntity<Object> getProducts() {
		
		return new ResponseEntity<Object>(productService.getAllProducts(), HttpStatus.OK);
			  
	 }

}
