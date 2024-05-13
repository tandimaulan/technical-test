package com.technical.test.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.technical.test.entities.Penjualan;

public interface PenjualanRepository extends JpaRepository<Penjualan, Long> {
    List<Penjualan> findByTanggalPenjualanBetween(LocalDate startDate, LocalDate endDate);
}
