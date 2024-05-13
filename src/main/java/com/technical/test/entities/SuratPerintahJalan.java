package com.technical.test.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "surat_perintah_jalan")
public class SuratPerintahJalan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSpj;

	@OneToOne
	@JoinColumn(name = "id_penjualan")
	private Penjualan penjualan;

	private String namaSopir;

	private String alamatTujuan;
}
