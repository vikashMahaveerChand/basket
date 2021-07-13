package com.basket.Basket;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasketResource {
	
	@Autowired
	BasketService basketService;
	
	@PostMapping(path="/basket")
	public BasketDTO saveBasket(@Valid @RequestBody BasketDTO basketDTO) {
		
		return basketService.save(basketDTO);
	}
	
	@GetMapping(path="/basket")
	public BasketDTO getBasket() {
		return basketService.findAll();
	}
	
	@GetMapping(path="/basket/{itemId}")
	public ResponseEntity<Basket> getBasketItem(@PathVariable("itemId") Integer basketId) {
		HttpStatus status = HttpStatus.OK;
		Basket basket = basketService.findBasket(basketId);
		
		if(basket==null) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<Basket>(basket,status);
	}
	
	@DeleteMapping(path="basket/{itemId}")
	public Basket deleteBasket(@PathVariable("itemId") Integer basketId){
		
		Basket basket = basketService.deleteBasket(basketId);
		
		return basket;
	}
	
	@PutMapping(path="/basket")
	public ResponseEntity<Basket> updateBasket(@RequestBody Basket basket) {
		HttpStatus status = HttpStatus.OK;
		Basket bas = basketService.updateBasket(basket);
		
		
		if(bas==null) {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<Basket>(bas,status);
		
	}
	
	

}
