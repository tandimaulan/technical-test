package com.technical.test.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "penjualan")
public class Penjualan {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPenjualan;

    @ManyToOne
    @JoinColumn(name = "id_produk")
    private Produk produk;

    @ManyToOne
    @JoinColumn(name = "id_toko")
    private Toko toko;

    private Integer qty;

    private BigDecimal hargaJual;

    private BigDecimal totalHarga;

    private LocalDate tanggalPenjualan;
}
