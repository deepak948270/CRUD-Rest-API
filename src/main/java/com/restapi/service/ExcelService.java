package com.restapi.service;

import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.entities.Employee;
import com.restapi.repository.EmployeeRepository;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ExcelService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public void generateExcelReport(HttpServletResponse response) throws IOException {

		List<Employee> employees = employeeRepository.findAll();
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("employee info");
		HSSFRow headerRow = sheet.createRow(0);

		headerRow.createCell(0).setCellValue("id");
		headerRow.createCell(1).setCellValue("first_name");
		headerRow.createCell(2).setCellValue("last_name");
		headerRow.createCell(3).setCellValue("email_id");

		int dataRowIndex = 1;

		for (Employee employee : employees) {
			HSSFRow dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(employee.getId());
			dataRow.createCell(1).setCellValue(employee.getFirstName());
			dataRow.createCell(2).setCellValue(employee.getLastName());
			dataRow.createCell(3).setCellValue(employee.getEmailId());

			dataRowIndex++;

		}

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();

	}

}
