package com.addmnistration.response;

public class SuccessResponse {
	private Object data;
	private String message;
	private Boolean success;
	private int code = ResponseCode.SUCCESS;
	
	public SuccessResponse() {
		
	}

    public SuccessResponse(Object data) {
        this.data = data;
        this.message="Operation completed successfully";
        this.success=true;
    }

    public SuccessResponse(Object data, String message) {
        this.data = data;
        this.message = message;
        this.success=true;
    }

    public SuccessResponse(Object data, String message, Boolean success, int code) {
		super();
		this.data = data;
		this.message = message;
		this.success = success;
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public Boolean getSuccess() {
		return success;
	}
	
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
