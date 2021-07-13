package com.basket.Basket;

public class Basket {
	private Integer basketId;
	
	
	private String name;
	private double cost;
	
	public Basket(Integer basketId, String name, double cost) {
		super();
		this.basketId = basketId;
		this.name = name;
		this.cost = cost;
	}
	
	public Integer getBasketId() {
		return basketId;
	}
	public void setBasketId(Integer basketId) {
		this.basketId = basketId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "Basket [basketId=" + basketId + ", name=" + name + ", cost=" + cost + "]";
	}
	
	
	
}
