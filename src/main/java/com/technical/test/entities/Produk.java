package com.technical.test.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produk")
public class Produk {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduk;

    private String namaProduk;

    private BigDecimal hargaStandar;

}
