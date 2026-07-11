package com.ecommerce.backend.exception;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private int status;
	private String msg;
	private long timestamp;
	
	public ErrorResponse(int status, String msg) {
		this.status = status;
		this.msg = msg;
		this.timestamp = System.currentTimeMillis();
	}

}
