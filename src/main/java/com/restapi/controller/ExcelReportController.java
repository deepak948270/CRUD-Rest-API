package com.restapi.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.service.ExcelService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/excel")
@Tag(name = "ExcelReport_Of_Employees")
public class ExcelReportController {

	@Autowired
	private ExcelService excelService;

	@GetMapping("/getreport")
	public void getExcelReport(HttpServletResponse response) throws IOException {

		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=employeeinfo.xls";
		response.setHeader(headerKey, headerValue);
		excelService.generateExcelReport(response);

	}

}
