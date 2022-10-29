package com.retoback.request;

import java.util.List;

import com.retoback.model.Content;

public class recetaRequest {

	int code;
	String message;
	List<Content> content;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Content> getContent() {
		return content;
	}
	public void setContent(List<Content> content) {
		this.content = content;
	}

}
