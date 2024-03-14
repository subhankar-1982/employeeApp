package com.details.employee.validation.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
	
	String statusCode;
	boolean statusFlag;
	String statusMessage;

}
