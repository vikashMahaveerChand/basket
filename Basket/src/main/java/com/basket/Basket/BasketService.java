package com.basket.Basket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BasketService {
	private static List<Basket> basket = new ArrayList<Basket>();
	private static int basketCount = 3;
	static {
		basket.add(new Basket(1,"Apple",100));
		basket.add(new Basket(2,"Orange",200));
		basket.add(new Basket(3,"Mango",300));
	}
	
	
	public BasketDTO findAll(){
		BasketDTO basketDTO = new BasketDTO();
		basketDTO.setBasket(basket);
		double totalCost = basket.stream().mapToDouble(Basket::getCost).sum();
		basketDTO.setTotalCost(totalCost);
		basketDTO.setBasketSize(basket.size());
		return basketDTO;
	}
	
	public BasketDTO save(BasketDTO basketDTO) {
		if(basketDTO.getBasket()!=null && basketDTO.getBasket().size()>0) {
			for(Basket basketObj:basketDTO.getBasket()) {
				if(basketObj.getBasketId()==null) {
					basketObj.setBasketId(++basketCount);
				}
				basket.add(basketObj);
			}
		}
		basketDTO.setBasket(basket);
		double totalCost = basket.stream().mapToDouble(Basket::getCost).sum();
		basketDTO.setTotalCost(totalCost);
		basketDTO.setBasketSize(basket.size());
		return basketDTO;
	}
	
	public Basket findBasket(Integer basketId) {
		Basket basketObj = null;
		for(Basket bas:basket) {
			if(bas.getBasketId()==basketId) {
				basketObj = bas;
			}
		}
		return basketObj;
	}
	
	public Basket deleteBasket(Integer basketId) {
		Basket basketObj = null;
		Iterator<Basket> iterator = basket.iterator();
		
		while(iterator.hasNext()) {
			Basket bas = iterator.next();
			if(bas.getBasketId()==basketId) {
				iterator.remove();
				basketObj = bas;
			}
		}
		return basketObj;
	}
	
	public Basket updateBasket(Basket basketObj) {
		
		/*basket = basket.stream().map(b -> b.getBasketId()==basketObj.getBasketId() ? basketObj:b)
		.collect(toList());*/
		Basket basObj = null;
		for(Basket bas:basket) {
			if(bas.getBasketId()==basketObj.getBasketId()) {
				bas.setCost(basketObj.getCost());
				bas.setName(basketObj.getName());
				basObj = bas;
			}
		}
		return basObj;
	}

}
