package com.example.report.penjualan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportDTO {
    private int no;
    private Long productId;
    private String productName;
    private String productType;
    private double salesPrice;
    private double salesMargin;
}
