package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	private int id;
	private String name;
	private int amount;
	
	public Item() {
		super();
	}
	
	public Item(int id, String name, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", amount=" + amount + "]";
	}
	
}
