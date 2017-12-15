package com.sf.marathon.dto;

import java.io.Serializable;

public class Offer implements Serializable {
	
	private String id;
	private String marketId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMarketId() {
		return marketId;
	}

	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}

	private static final long serialVersionUID = 1L;

}
