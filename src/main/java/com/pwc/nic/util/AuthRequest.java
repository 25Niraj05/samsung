package com.pwc.nic.util;

public class AuthRequest {

	private boolean ForceRefreshAccessToken;
	private String username = null;
	private String password = null;
	private String app_key = null;

	public AuthRequest(boolean forceRefreshAccessToken, String username, String password,
			String app_key) {
		super();
		this.ForceRefreshAccessToken = forceRefreshAccessToken;
		this.username = username;
		this.password = password;
		this.app_key = app_key;
	}


	public boolean isForceRefreshAccessToken() {
		return ForceRefreshAccessToken;
	}

	public void setForceRefreshAccessToken(boolean forceRefreshAccessToken) {
		ForceRefreshAccessToken = forceRefreshAccessToken;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApp_key() {
		return app_key;
	}

	public void setApp_key(String app_key) {
		this.app_key = app_key;
	}

	@Override
	public String toString() {
		StringBuilder sb =new StringBuilder();
		sb.append("{ ForceRefreshAccessToken : " + this.ForceRefreshAccessToken + ", UserName : " + this.username + ", Password : " + this.password + ", AppKey : " + this.app_key + "}");
		return sb.toString();
	}
}
