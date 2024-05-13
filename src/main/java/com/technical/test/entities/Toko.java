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
@Table(name = "toko")
public class Toko {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idToko;

    private String namaToko;

    private BigDecimal keuntungan;
}
