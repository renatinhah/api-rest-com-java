package br.com.dito.desafio.renata.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "eventos")
public class Evento {
	@Id
	private ObjectId _id;
	private String event;
	private String timestamp;
	private String productName;
	private String transactionId;
	private double productPrice;
	private String storeName;
	private double revenue;
	
	public Evento(){}
	
	//constroi um evento comprou
	public Evento(ObjectId _id, String timestamp, double revenue, String storeName, String transactionId) {
		this._id = _id;
		this.event = "comprou";
		this.timestamp = timestamp;
		this.revenue = revenue;
		this.storeName = storeName;
		this.transactionId = transactionId;
	}
	
	//constroi um evento comprou-produto
	public Evento(ObjectId _id, String timestamp, String productName, String transactionId, double productPrice) {
		this._id = _id;
		this.event = "comprou-produto";
		this.timestamp = timestamp;
		this.productName = productName;
		this.transactionId = transactionId;
		this.productPrice = productPrice;
	}
	
	public String get_id() {
		return _id.toHexString();
	}
	
	public void set_id(Object _id) {
		this._id = (ObjectId) _id;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	
	
}