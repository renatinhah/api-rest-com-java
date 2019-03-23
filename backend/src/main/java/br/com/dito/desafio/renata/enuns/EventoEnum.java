package br.com.dito.desafio.renata.enuns;

public enum EventoEnum {
	
	EVENTO_COMPROU("comprou"),
	EVENTO_COMPROU_PRODUTO("comprou-produto"),
	PRODUCT_NAME("product_name"),
	PRODUCT_PRICE("product_price"),
	TRANSACTION_ID("transaction_id"),
	STORE_NAME("store_name"),
	TIMESTAMP("timestamp"),
	EVENTO("event");
	
	
	private String event;

	EventoEnum(String event) {
		this.event = event;
	}

	public String getEvent() {
		return event;
	}

}
