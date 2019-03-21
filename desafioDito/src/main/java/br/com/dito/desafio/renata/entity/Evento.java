package br.com.dito.desafio.renata.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "eventos")
public class Evento {
	@Id
	private String id;
	private String event;
	private String timestamp;
	private double revenue;
	@Field("custom_data")
	private ArrayList<CustomData> customData;
	
	public Evento(){}
	
	public Evento(String id, String timestamp, double revenue, String storeName, String transactionId) {
		this.id = id;
		this.event = "comprou";
		this.timestamp = timestamp;
		this.revenue = revenue;
	}
	
	public Evento(String id, String timestamp) {
		this.id = id;
		this.event = "comprou-produto";
		this.timestamp = timestamp;
	
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

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

	public ArrayList<CustomData> getCustomData() {
		return customData;
	}

	public void setCustomData(ArrayList<CustomData> customData) {
		this.customData = customData;
	}

	
}