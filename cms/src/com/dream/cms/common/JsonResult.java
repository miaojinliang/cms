package com.dream.cms.common;

public class JsonResult<T> {

	public final static int CLIENT_ERROR = -20000;
	public final static int SERVER_ERROR = -10000;
	public final static int SESSION_EXPIRED = -3;
	public final static int LOGIN_FAIL = -2;
	public final static int UNKNOWN = -1;
	public final static int SUCCESS = 0;

	private int code = UNKNOWN;

	private String message;

	private T result;

	public JsonResult(T result) {
		this.result = result;
	}

	public JsonResult<T> success() {
		this.code = SUCCESS;
		this.message = "";
		return this;
	}

	public JsonResult<T> success(String message) {
		this.code = SUCCESS;
		this.message = message;
		return this;
	}

	public JsonResult<T> fail(int code) {
		this.code = code;
		this.message = "";
		return this;
	}

	public JsonResult<T> fail(int code, String message) {
		this.code = code;
		this.message = message;
		return this;
	}

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

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

}
