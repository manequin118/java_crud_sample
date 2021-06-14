package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ItemEntity;
import com.example.demo.repositries.ItemRepository;

import java.util.List;
import java.util.Optional;


@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	public List<ItemEntity> findAll() {
		
		return itemRepository.findAll();
	}
	
	
	public ItemEntity save(ItemEntity itemEntity) {
		
		return itemRepository.saveAndFlush(itemEntity);
	}
	
	public Optional<ItemEntity> findById(Long id) {
		
		return itemRepository.findById(id);
	}
	
    public void delete(ItemEntity itemEntity) {
    	
        itemRepository.delete(itemEntity); 
    } 
	

}
 