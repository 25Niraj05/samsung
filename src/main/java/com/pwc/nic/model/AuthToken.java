package com.pwc.nic.model;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("IRN-AuthToken")
public class AuthToken {
	private String id;
	private String gstin;
	private String response;
	private String txnId;
	private long createdTime;

	public AuthToken(String gstin, String response, String txnId) {
		super();
		this.id = gstin;
		this.gstin = gstin;
		this.response = response;
		this.txnId = txnId;
		this.createdTime = System.currentTimeMillis();
	}


	public AuthToken() {
		super();
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public long getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(long createdTime) {
		this.createdTime = createdTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

}
