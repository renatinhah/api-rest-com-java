package br.com.dito.desafio.renata.entity;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Field;

public class Timeline {
	private String timestamp;
	private double revenue;
	private String transactionId;
	private String storeName;
	private ArrayList<Products> products;
	
	public Timeline(){}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public ArrayList<Products> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Products> products) {
		this.products = products;
	}
	
}
