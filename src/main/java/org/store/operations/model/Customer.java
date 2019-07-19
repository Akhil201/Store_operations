package org.store.operations.model;

import java.io.Serializable;
import java.util.Date;

import org.store.operations.util.CustomerType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 74125896L;

	private String id;

	private CustomerType type;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date createdAt;

	public CustomerType getType() {
		return type;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Customer(String id, CustomerType type, Date createdAt) {
		super();
		this.id = id;
		this.type = type;
		this.createdAt = createdAt;
	}

	public Customer() {
		super();
	}

}
