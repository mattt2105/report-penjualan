package com.example.report.penjualan.service;

import com.example.report.penjualan.domain.Product;
import com.example.report.penjualan.domain.Transaction;
import com.example.report.penjualan.dto.ReportDTO;
import com.example.report.penjualan.repository.ProductRepository;
import com.example.report.penjualan.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public List<ReportDTO> getSalesReport(Date startDate, Date endDate) {
        List<Transaction> transactions = transactionRepository.findByTransactionDateBetween(startDate, endDate);
        List<ReportDTO> report = new ArrayList<>();
        int no =1;

        for (Transaction transaction : transactions) {
            Product product = productRepository.findById(transaction.getProductId()).orElse(null);
            if (product != null) {
                ReportDTO dto = new ReportDTO();
                dto.setNo(no);
                dto.setProductId(product.getProductId());
                dto.setProductName(product.getName());
                dto.setProductType(product.getType());
                dto.setSalesPrice(product.getPrice());
                dto.setSalesMargin(product.getPrice() * 0.05);
                report.add(dto);
                no++;
            }
        }

        return report;
    }


}
