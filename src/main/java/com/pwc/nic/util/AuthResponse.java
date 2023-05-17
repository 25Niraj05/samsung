package com.pwc.nic.util;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;

public class AuthResponse {

	private HttpStatus Status;
	private JSONObject ErrorDetails;
	private Object Data;

	public AuthResponse() {
		// Auto-generated constructor stub
	}

	public AuthResponse(HttpStatus Status, JSONObject ErrorDetails, Object Data) {
		this.Status = Status;
		this.ErrorDetails = ErrorDetails;
		this.Data = Data;
	}

	public HttpStatus getStatus() {
		return Status;
	}

	public void setStatus(HttpStatus status) {
		Status = status;
	}

	public JSONObject getErrorDetails() {
		return ErrorDetails;
	}

	public void setErrorDetails(JSONObject errorDetails) {
		ErrorDetails = errorDetails;
	}

	public Object getData() {
		return Data;
	}

	public void setData(Object data) {
		Data = data;
	}

	@Override
	public String toString() {
		StringBuilder sb =new StringBuilder();
		sb.append("{ Status : " + this.Status + ", ErrorDetails : " + this.ErrorDetails + ", Data : " + this.Data +"}");
		return sb.toString();
	}
}
