package edu.mum.cs544.project.ecruit.exception;

public class CustomGenericException extends RuntimeException {
	 
	private static final long serialVersionUID = 1L;
 
	private String title;
	private String message;
	public CustomGenericException(String title, String message) {
		super();
		this.title = title;
		this.message = getStackTrace().toString();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return getStackTrace().toString();
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
