package com.details.employee.exception;

import com.details.employee.validation.util.Message;

public class InvalidInputDetailsException  extends Exception{

	String satusCode;
	String statusMessage;
	boolean statusFlag;
	public InvalidInputDetailsException(Message message) {
		super(message.getStatusMessage());
		this.satusCode=message.getStatusCode();
		this.statusFlag = message.isStatusFlag();
		this.statusMessage=message.getStatusMessage();
	}
	
}
