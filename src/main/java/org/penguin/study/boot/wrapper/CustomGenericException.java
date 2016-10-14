package org.penguin.study.boot.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * Created by terry on 14/10/2016.
 */
public class CustomGenericException implements Serializable {

	private static final long serialVersionUID = -2298787498718283447L;

	private String errorCode;
	private String errorMessage;

	public CustomGenericException() {
	}

	public CustomGenericException(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@JsonIgnore
	public Throwable[] getSuppressed() {
		return null;
	}
}
