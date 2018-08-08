package com.example.demo;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
	
	@Autowired
	ItemRepo repo;
	
	@GetMapping("/items")
	public List<Item> allitems() {
		return (List<Item>)repo.findAll();
	}
	
	@GetMapping("/items/{id}")
	public Item getItem(@PathVariable("id") int id) throws Exception {
		Optional<Item> item = repo.findById(id);
		
		if (!item.isPresent())
			throw new Exception("id - " + id);
		return item.get();
	}
	
	@DeleteMapping("/items/{id}")
	public void deleteItem(@PathVariable("id") int id) {
		repo.deleteById(id);
	}
	
	@PatchMapping("/items/withdrawal/{id}")
	public void withdrawalItem(@PathVariable("id") int id, int amount) throws Exception {
		Item item = getItem(id);
		item.setAmount(item.getAmount()-amount);
		repo.save(item);
	}
	
	@PatchMapping("/items/deposit/{id}")
	public void depositItem(@PathVariable("id") int id, int amount) throws Exception {
		Item item = getItem(id);
		item.setAmount(item.getAmount()+amount);
		repo.save(item);
	}
	
	@PostMapping("/items/addItem")
	public void addItem(@RequestBody Item item) {
		repo.save(item);
	}
}
