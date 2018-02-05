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
@Table(name="BIAYA")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class BiayaModel {
	private Integer id;
	private String nama;
	private Integer harga;
	
	@Id
	@Column(name="BIAYA_ID")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="BIAYA")
	@TableGenerator(name="BIAYA",table="SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="BIAYA", valueColumnName="SEQUENCE_VALUE", allocationSize=0, initialValue=0)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="NAMA_BIAYA")
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	@Column(name="HARGA")
	public Integer getHarga() {
		return harga;
	}
	public void setHarga(Integer harga) {
		this.harga = harga;
	}	
	
}
