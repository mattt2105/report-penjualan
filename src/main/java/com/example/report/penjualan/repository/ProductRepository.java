package com.example.report.penjualan.repository;

import com.example.report.penjualan.domain.Product;
import com.example.report.penjualan.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
