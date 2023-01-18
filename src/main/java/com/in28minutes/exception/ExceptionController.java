package com.in28minutes.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice   //codes in this class are applicable to all controllers, such as global exception handling, global binders
public class ExceptionController {
	private Log logger = LogFactory.getLog(ExceptionController.class);

	@ExceptionHandler(value = Exception.class)    //whenever there is an exception, this method is called. This is called Global Exception Handling
	public String handleException(HttpServletRequest request, Exception ex) {
		logger.error("Request: " + request.getRequestURL() + " raised an exception: " + ex);
		return "error";
	}
}