package com.example.report.penjualan.controller;

import com.example.report.penjualan.dto.ReportDTO;
import com.example.report.penjualan.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ReportController {

    @Autowired
    ReportService service;

    @GetMapping("/sales-report")
    public List<ReportDTO> getSalesReport(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return service.getSalesReport(startDate, endDate);
    }
}
