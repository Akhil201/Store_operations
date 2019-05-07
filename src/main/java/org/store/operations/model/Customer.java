package org.store.operations.model;

public class Customer {
	
	private String id;
	
	private String type;
	
	private String createdAt;
	
	private String name;

	public String getId() {
		return id;
	}


	public String getType() {
		return type;
	}


	public String getCreatedAt() {
		return createdAt;
	}


	public String getName() {
		return name;
	}


	public Customer(String id, String type, String createdAt, String name) {
		super();
		this.id = id;
		this.type = type;
		this.createdAt = createdAt;
		this.name = name;
	}

}
