package com.danh.assignment.thirdparty.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.danh.assignment.thirdparty.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
@ControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Object handleConstraintViolationException(NotFoundException e, HttpServletRequest request,
			HttpServletResponse response) {
		log.error(e.getMessage(), e);
		return ResponseDTO.builder().code("404").status("Not Found").message("Not Found").build();
	}

}