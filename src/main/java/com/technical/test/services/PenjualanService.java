package com.technical.test.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technical.test.entities.Penjualan;
import com.technical.test.repositories.PenjualanRepository;

@Service
public class PenjualanService {
    @Autowired
    private PenjualanRepository penjualanRepository;

    public List<Penjualan> getPenjualanByDateRange(LocalDate startDate, LocalDate endDate) {
        return penjualanRepository.findByTanggalPenjualanBetween(startDate, endDate);
    }
}