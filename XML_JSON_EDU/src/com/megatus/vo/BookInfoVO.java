package com.megatus.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bookInfo")
public class BookInfoVO {

	private List<ItemVO> item;

	public List<ItemVO> getItem() {
		return item;
	}

	public void setItem(List<ItemVO> item) {
		this.item = item;
	}

}