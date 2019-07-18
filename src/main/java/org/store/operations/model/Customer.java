package org.store.operations.model;

public class Customer {
	
	private String id;
	
	private String type;
	
	private String createdAt;
	
	private String name;


	public String getType() {
		return type;
	}


	public String getCreatedAt() {
		return createdAt;
	}




	public Customer(String id, String type, String createdAt, String name) {
		super();
		this.id = id;
		this.type = type;
		this.createdAt = createdAt;
		this.name = name;
	}


	public Customer() {
		super();
	}
	
}
