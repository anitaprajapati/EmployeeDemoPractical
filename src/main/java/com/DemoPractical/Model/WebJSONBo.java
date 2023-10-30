package com.DemoPractical.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class WebJSONBo {

	@JsonInclude(Include.NON_NULL)
	private String return_message;
	
	@JsonInclude(Include.NON_NULL)
	private String status;
	
	@JsonInclude(Include.NON_NULL)
	private Object responseData;

	public String getReturn_message() {
		return return_message;
	}

	public void setReturn_message(String return_message) {
		this.return_message = return_message;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getResponseData() {
		return responseData;
	}

	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}
	
	
	
}
