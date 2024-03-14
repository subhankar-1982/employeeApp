package com.details.employee.validation.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.details.employee.constant.PropertyConstant;
import com.details.employee.dto.EmployeeDto;

public interface EmployeeFieldValidationUtil {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static final Pattern PHONE_NUMBER_REGEX = Pattern.compile("^\\+?\\d{8,15}$");

	public static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^\\+?[0-9]+(?:,[0-9]+)*$");

	public static Message validateEmployee(EmployeeDto dto) {
		Message responseMessage = new Message();
		responseMessage.setStatusCode("200");
		responseMessage.setStatusFlag(false);
		responseMessage.setStatusMessage("Valid");

		if (Objects.isNull(dto.getFname()) || (dto.getFname() != null && dto.getFname().trim().isEmpty())) {
			responseMessage = setMessage(PropertyConstant.REQUEST_STATUS_CODE, true, PropertyConstant.FNAME_REQUIRED,
					responseMessage);
		}

		if (!isValidName(dto.getFname())) {
			responseMessage = setMessage(PropertyConstant.REQUEST_STATUS_CODE, true, PropertyConstant.FNAME_INVALID,
					responseMessage);
		}

		if (!Objects.isNull(dto.getLname()) && !dto.getLname().trim().isEmpty() && !isValidName(dto.getLname())) {
			responseMessage = setMessage(PropertyConstant.REQUEST_STATUS_CODE, true, PropertyConstant.LNAME_INVALID,
					responseMessage);
		}

		if (Objects.isNull(dto.getEmail()) || (dto.getEmail() != null && dto.getEmail().trim().isEmpty())) {
			responseMessage = setMessage(PropertyConstant.REQUEST_STATUS_CODE, true, PropertyConstant.EMAIL_REQUIRED,
					responseMessage);
		}

		if (!isEmailValid(dto.getEmail())) {
			responseMessage = setMessage(PropertyConstant.REQUEST_STATUS_CODE, true, PropertyConstant.INVALID_EMAILID,
					responseMessage);
		}

		String phoneNumber = dto.getPhone_num();

		if (Objects.isNull(phoneNumber) || (phoneNumber != null && phoneNumber.isEmpty())) {
			responseMessage = setMessage(PropertyConstant.REQUEST_STATUS_CODE, true,
					PropertyConstant.PHONE_NUMBER_REQUIRED, responseMessage);
		}
		if (!PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches()) {
			responseMessage = setMessage(PropertyConstant.REQUEST_STATUS_CODE, true,
					PropertyConstant.PHONE_NUMBER_INVALID_SPLITER, responseMessage);
		} else {
			String[] phoneArray = phoneNumber.split(",");
			responseMessage = validateMultiplePhoneNumber(phoneArray, responseMessage);
		}
		if (Objects.isNull(dto.getDoj()) || (dto.getDoj() != null && dto.getDoj().toString().trim().isEmpty())) {
			responseMessage = setMessage(PropertyConstant.REQUEST_STATUS_CODE, true, PropertyConstant.DOJ_REQUIRED,
					responseMessage);
		}
		if (!isValidDateFormat(dto.getDoj().toString())) {
			responseMessage = setMessage(PropertyConstant.REQUEST_STATUS_CODE, true, PropertyConstant.DOJ_FORMAT,
					responseMessage);
		}
		return responseMessage;
	}

	public static Message validateMultiplePhoneNumber(String[] phoneArray, Message responseMessage) {

		for (String phNumber : phoneArray) {
			if (!isPhoneNumberValid(phNumber)) {
				responseMessage.setStatusCode(PropertyConstant.REQUEST_STATUS_CODE);
				responseMessage.setStatusFlag(true);
				responseMessage.setStatusMessage(PropertyConstant.PHONE_NUMBER_INVALID);
				break;
			}
		}
		return responseMessage;
	}

	public static boolean isValidDateFormat(String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		sdf.setLenient(false);
		try {
			Date date = sdf.parse(dateString);
			return sdf.format(date).equals(dateString);
		} catch (ParseException e) {
			return false;
		}
	}

	public static boolean isEmailValid(String email) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		return matcher.matches();
	}

	public static Message setMessage(String statusCode, boolean statusFlag, String statusMessage,
			Message responseMessage) {
		responseMessage.setStatusCode(statusCode);
		responseMessage.setStatusFlag(statusFlag);
		responseMessage.setStatusMessage(statusMessage);
		return responseMessage;
	}

	public static boolean isValidName(String name) {
		String regEx = "^[a-zA-Z]+$";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}

	public static boolean isPhoneNumberValid(String phoneNumber) {
		Matcher matcher = PHONE_NUMBER_REGEX.matcher(phoneNumber);
		return matcher.matches();
	}

}
