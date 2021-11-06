package com.sds.DSVendas.dto;

import java.io.Serializable;

import com.sds.DSVendas.entities.Seller;

public class SellersSuccessDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public String name;
	public Long visited;
	public Long deals;
	
	public SellersSuccessDTO(){	
	}

	public SellersSuccessDTO(Seller seller, Long visited, Long deals) {
		name = seller.getName();
		this.visited = visited;
		this.deals = deals;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getVisited() {
		return visited;
	}

	public void setVisited(Long visited) {
		this.visited = visited;
	}

	public Long getDeals() {
		return deals;
	}

	public void setDeals(Long deals) {
		this.deals = deals;
	}
}
