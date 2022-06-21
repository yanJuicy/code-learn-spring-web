package org.zerock.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.zerock.controller.SampleController;

@ControllerAdvice
public class CommonExceptionAdvice {
	
	private static final Logger log = LoggerFactory.getLogger(SampleController.class);

	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		log.error("Excpetion....." + ex.getMessage());
		model.addAttribute("excpetion", ex);
		log.error(model.toString());
		return "error_page";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex) {
		return "customer404";
	}
	
}
