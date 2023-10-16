package com.restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Test")
public class TestController {

	@Operation(description = "get test handler", summary = "wanted to expose test endpoint ", responses = {
			@ApiResponse(description = "sucess", responseCode = "200"

			) })
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path = "/test1")
	public String test1() {
		//System.out.println(0/0);
		return "test.............";

	}

	@Hidden
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path = "/test2")
	public String test2() {
		return "test2";
	}

}
