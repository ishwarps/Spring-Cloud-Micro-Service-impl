package com.example.priceInfoMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.priceInfoMS.service.PriceService;

@RestController
@RequestMapping("/price")
public class PriceInfoMSController {
	
	@Autowired(required = true)
	@Qualifier("priceService")
	PriceService priceService;
	
	@RequestMapping(value = "/productId/{productId}", method = RequestMethod.GET)
	 public ResponseEntity<Object> getProducts(@PathVariable("productId") String productId) {
		
		return new ResponseEntity<Object>(priceService.getProductPrice(productId), HttpStatus.OK);
		
		
	 }

}
