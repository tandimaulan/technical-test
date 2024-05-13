package com.technical.test.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technical.test.entities.Penjualan;
import com.technical.test.services.PenjualanService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class SalesReportController {
	@Autowired
	private PenjualanService penjualanService;

	@GetMapping("/sales-report")
	public void generateSalesReport(HttpServletResponse response) throws IOException {
	    LocalDate startDate = LocalDate.now().minusMonths(12);
	    LocalDate endDate = LocalDate.now();
	    List<Penjualan> penjualanList = penjualanService.getPenjualanByDateRange(startDate, endDate);

	    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	    response.setHeader("Content-Disposition", "attachment; filename=\"sales_report.xlsx\"");

	    Workbook workbook = new XSSFWorkbook();
	    Sheet sheet = workbook.createSheet("Sales Report");

	    String[] headers = {"Tanggal Penjualan", "Nama Produk", "Nama Toko", "Qty", "Harga Jual", "Total Harga"};

	    Row headerRow = sheet.createRow(0);
	    for (int i = 0; i < headers.length; i++) {
	        Cell cell = headerRow.createCell(i);
	        cell.setCellValue(headers[i]);
	    }

	    int rowNum = 1;
	    for (Penjualan penjualan : penjualanList) {
	        Row row = sheet.createRow(rowNum++);
	        row.createCell(0).setCellValue(penjualan.getTanggalPenjualan().toString());
	        row.createCell(1).setCellValue(penjualan.getProduk().getNamaProduk());
	        row.createCell(2).setCellValue(penjualan.getToko().getNamaToko());
	        row.createCell(3).setCellValue(penjualan.getQty());
	        row.createCell(4).setCellValue(penjualan.getHargaJual().doubleValue());
	        row.createCell(5).setCellValue(penjualan.getTotalHarga().doubleValue());
	    }

	    workbook.write(response.getOutputStream());
	    workbook.close();
	}
}
