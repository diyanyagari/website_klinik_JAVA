package com.xsis.bootcamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="OBAT")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class ObatModel {
	private Integer id;
	private String nama;
	private String kemasan;
	private Integer harga;
	private String dosis;
	
	@Id
	@Column(name="OBAT_ID")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="OBAT")
	@TableGenerator(name="OBAT",table="SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="OBAT", valueColumnName="SEQUENCE_VALUE", allocationSize=0, initialValue=0)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="NAMA_OBAT")
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	@Column(name="KEMASAN")
	public String getKemasan() {
		return kemasan;
	}
	public void setKemasan(String kemasan) {
		this.kemasan = kemasan;
	}
	
	@Column(name="HARGA")
	public Integer getHarga() {
		return harga;
	}
	public void setHarga(Integer harga) {
		this.harga = harga;
	}
	
	@Column(name="DOSIS")
	public String getDosis() {
		return dosis;
	}
	public void setDosis(String dosis) {
		this.dosis = dosis;
	}
	
}
