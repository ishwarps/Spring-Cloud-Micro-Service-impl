package com.example.priceInfoMS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.priceInfoMS.model.Price;


@Service("priceService")
public class PriceServiceImpl implements PriceService{

	@Autowired
	Price price;
	
	@Override
	public Price getProductPrice(String productId) {		

		price.setPriceId("priceId-1223");
		price.setProductPrice(2000);
		price.setProductId(productId);		
		return price;
	}

}
