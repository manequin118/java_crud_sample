package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class ItemEntity {
	//TODO itemnameでうまく一覧表示できない
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String itemname;

	private Integer price;

	private String content;

	public ItemEntity() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public ItemEntity(long id, String itemname, Integer price, String content) {
		this.id = id;
		this.itemname = itemname;
		this.price = price;
		this.content = content;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getItemname() {
		return itemname;
	}


	public void setItemname(String itemname) {
		this.itemname = itemname;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
}
