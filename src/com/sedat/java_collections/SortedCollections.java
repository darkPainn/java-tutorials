package com.sedat.java_collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author sedat.turkoglu
 * LinkedHashMap and LinkedHashSet are variant of HashMap and HashSet classes
 * There are also sorted version of Map and Set interfaces SortedMap and SortedSet that are implemented in TreeMap and TreeSet.
 * 
 */
public class SortedCollections {
	
	public static void main(String[] args) {
	}
	
}


class StockItem implements Comparable<StockItem>{
	
	private final String name;
	private double price;
	private int quantity;

	public StockItem(String name, double price) {
		this.price = price;
		this.name = name;
		this.quantity = 0;
	}

	public StockItem(String name, double price, int stock) {
		this.price = price;
		this.name = name;
		this.quantity = stock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if(price > 0.0) {
			this.price = price;
		}
	}

	public int getStock() {
		return quantity;
	}

	public void setStock(int stock) {
		int newQuantity = this.quantity + stock;
		if(newQuantity > 0) {
			this.quantity = stock;
		}
	}

	public String getName() {
		return name;
	}
	
	@Override
	public boolean equals(Object another) {
		if(another == this)return true;
		if( (another == null) || (another.getClass() != this.getClass()) ) {
			return false;
		}
		String anotherName = ((StockItem) another).getName();
		return this.getName().equals(anotherName);
	}
	
	@Override
	public int hashCode() {
		//the number we add at the end can be anything
		return this.getName().hashCode() + 31;
	}

	@Override
	public int compareTo(StockItem another) {
		if(this == another) {
			return 0;
		}
		if(another != null) {
			return this.getName().compareTo(another.getName());
		}
		throw new NullPointerException();
	}
	
	@Override
	public String toString() {
		return this.getName() + " price: " + this.getPrice();
	}
	
}

class StockList{
	private final Map<String, StockItem> items;
	
	public StockList() {
		this.items = new HashMap<>();
	}
	
	public int addStockItem(StockItem item) {
		if(item != null) {
			StockItem iteminstock = items.getOrDefault(item.getName(), item);
			if(iteminstock != item) {
				item.setStock(iteminstock.getStock());
			}
			items.put(item.getName(), item);
			return item.getStock();
		}
		return 0;
	}
	
	public int sellStock(String itemName, int quantity) {
		StockItem item = this.items.getOrDefault(itemName, null);
		if( (item != null) && (item.getStock() >= quantity) && (quantity > 0) ) {
			item.setStock(-quantity);
			return quantity;
		}
		return 0;
	}
	
	public StockItem getItem(String itemName) {
		return this.items.get(itemName);
	}
	
	public Map<String, StockItem> Items(){
		return Collections.unmodifiableMap(this.items);
	}
}

class Basket{
	private final String name;
	private final Map<StockItem, Integer> list;
	
	public Basket(String name) {
		this.name = name;
		this.list = new HashMap<>();
	}
	
	public int addToBasket(StockItem item, int quantity) {
		if( (item != null) && (quantity > 0) ) {
			int quantitiyInBasket = list.getOrDefault(item, 0);
			list.put(item, quantitiyInBasket + quantity);
			return quantitiyInBasket;
		}
		return 0;
	}
	
	public Map<StockItem, Integer> Items(){
		return Collections.unmodifiableMap(list);
	}
}

























