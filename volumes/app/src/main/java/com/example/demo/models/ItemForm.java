package com.example.demo.models;


import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ItemForm implements Serializable {
	private static final long serialVersionUID = -6647247658748349084L;


	private long id;

	@NotBlank
	@Size(max = 10)
	private String itemname;

	@Max(99999)
    @Min(1)
	private Integer price;

	@NotBlank
	@Size(max = 400)
	private String content;
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getItemname() {
		return itemname;
	}


	public  void setItemname(String itemname) {
		this.itemname = itemname;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price= price;
	}

	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public void clear() {
		itemname = null;
		price = null;
		content = null;
	}
}
