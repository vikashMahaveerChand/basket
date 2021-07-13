package com.basket.Basket;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class BasketDTO {
	
	private Double totalCost;
	private int basketSize;
	
	@NotEmpty
	@Size(min=1)
	List<Basket> basket;
	
	
	protected BasketDTO() {}
	
	public BasketDTO(Double totalCost, int basketSize, List<Basket> basket) {
		super();
		this.totalCost = totalCost;
		this.basketSize = basketSize;
		this.basket = basket;
	}

	@Override
	public String toString() {
		return "BasketDTO [totalCost=" + totalCost + ", basketSize=" + basketSize + ", basket=" + basket + "]";
	}

	public List<Basket> getBasket() {
		return basket;
	}
	public void setBasket(List<Basket> basket) {
		this.basket = basket;
	}
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	public int getBasketSize() {
		return basketSize;
	}
	public void setBasketSize(int basketSize) {
		this.basketSize = basketSize;
	}

}
