package com.example.productInfoMS.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.productInfoMS.client.PriceClient;
import com.example.productInfoMS.model.Price;
import com.example.productInfoMS.model.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired(required = true)	
	Product product;
	
	@Autowired(required = true)	
	PriceClient priceClient;
		
	private String serverURL;
	
	public List<Product> getAllProducts(){
		List<Product> productList=new ArrayList<Product>();	
		try
		{				
			
			
			System.out.println("service url is::"+priceClient.getServiceUrl());
			serverURL=priceClient.getServiceUrl();
			
			
			logger.info("serverURL variable is===="+serverURL);		
			URI uri = URI.create(serverURL+"price/productId/productId-1");
			RestTemplate restTemplate = new RestTemplate();
			
			Price price= restTemplate.getForObject(uri, Price.class);				
			
			logger.info("@@@@  product price;;;"+price.getProductPrice());
			//System.exit(1);
			product.setProductId("productId-1");
			product.setProductInfo("sample Demo");
			product.setProductName("dove");		
			product.setProductPrice(price.getProductPrice());
			productList.add(product);			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}	
		
		return productList; 
	}

}
