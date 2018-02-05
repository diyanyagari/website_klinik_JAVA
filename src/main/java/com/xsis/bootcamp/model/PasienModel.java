package com.xsis.bootcamp.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="PASIEN")//nama tabel di database
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")//di ganti @id
public class PasienModel {
	private Integer id;
	private Integer nomorRm;
	private String nama;
	private String alamat;
	private Integer propinsiId;
	private Integer kotaId;
	private Integer kecamatanId;
	private String JK;
	private String tempatLahir;
	private String tglLahir;
	private String pekerjaan;
	private PropinsiModel propinsi;
	
	
	@Id
	@Column(name="ID")//nama kolom
	@GeneratedValue(strategy=GenerationType.TABLE,generator="PENYAKIT")
	@TableGenerator(name="PENYAKIT",table="SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="PENYAKIT", valueColumnName="SEQUENCE_VALUE", allocationSize=0, initialValue=0)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="NOMOR_RM")
	public Integer getNomorRm() {
		return nomorRm;
	}
	public void setNomorRm(Integer nomorRm) {
		this.nomorRm = nomorRm;
	}
	
	@Column(name="NAMA")
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	@Column(name="ALAMAT")
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	
	@Column(name="PROPINSI")
	public Integer getPropinsiId() {
		return propinsiId;
	}
	public void setPropinsiId(Integer propinsiId) {
		this.propinsiId = propinsiId;
	}
	
	@Column(name="KOTA_ID")
	public Integer getKotaId() {
		return kotaId;
	}
	public void setKotaId(Integer kotaId) {
		this.kotaId = kotaId;
	}
	
	@Column(name="KECAMATAN_ID")
	public Integer getKecamatanId() {
		return kecamatanId;
	}
	public void setKecamatanId(Integer kecamatanId) {
		this.kecamatanId = kecamatanId;
	}
	
	@Column(name="JK")
	public String getJK() {
		return JK;
	}
	public void setJK(String jK) {
		JK = jK;
	}
	
	@Column(name="TEMPAT_LAHIR")
	public String getTempatLahir() {
		return tempatLahir;
	}
	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}
	
	@Column(name="TGL_LAHIR")
	public String getTglLahir() {
		return tglLahir;
	}
	public void setTglLahir(String tglLahir) {
		this.tglLahir = tglLahir;
	}
	
	@Column(name="PEKERJAAN")
	public String getPekerjaan() {
		return pekerjaan;
	}
	public void setPekerjaan(String pekerjaan) {
		this.pekerjaan = pekerjaan;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PROPINSI", nullable=false, insertable=false, updatable=false)
	public PropinsiModel getPropinsi() {
		return propinsi;
	}
	public void setPropinsi(PropinsiModel propinsi) {
		this.propinsi = propinsi;
	}
	
}
