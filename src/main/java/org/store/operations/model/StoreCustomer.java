package org.store.operations.model;

public class StoreCustomer {
	
	private String id;
	
	private String type;
	
	private String createdAt;
	
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StoreCustomer(String id, String type, String createdAt, String name) {
		super();
		this.id = id;
		this.type = type;
		this.createdAt = createdAt;
		this.name = name;
	}
	
	public StoreCustomer() {
		super();
	}

}
