package com.xsis.bootcamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="DETAIL_KUNJUNGAN")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class DetailKunjunganModel {
	private Integer id;
	private Integer kunjunganId;
	private Integer biayaId;
	private Integer harga;
	private Integer banyak;
	private Integer subTotal;
	private KunjunganModel kunjungan;
	
	@Id
	@Column(name="DETAIL_KUNJUNGAN_ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="DETAIL_KUNJUNGAN_ID")
	@TableGenerator(name="DETAIL_KUNJUNGAN_ID",table="SEQUENCE",pkColumnName="SEQUENCE_ID",pkColumnValue="DETAIL_KUNJUNGAN_ID",valueColumnName="SEQUENCE_VALUE",allocationSize=0,initialValue=0)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="KUNJUNGAN_ID")
	public Integer getKunjunganId() {
		return kunjunganId;
	}
	public void setKunjunganId(Integer kunjunganId) {
		this.kunjunganId = kunjunganId;
	}
	
	@Column(name="BIAYA_ID")
	public Integer getBiayaId() {
		return biayaId;
	}
	public void setBiayaId(Integer biayaId) {
		this.biayaId = biayaId;
	}
	
	@Column(name="HARGA_ID")
	public Integer getHarga() {
		return harga;
	}
	public void setHarga(Integer harga) {
		this.harga = harga;
	}
	
	@Column(name="JUMLAH")
	public Integer getBanyak() {
		return banyak;
	}
	public void setBanyak(Integer banyak) {
		this.banyak = banyak;
	}
	
	@Column(name="SUB_TOTAL")
	public Integer getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Integer subTotal) {
		this.subTotal = subTotal;
	}
	
	@ManyToOne
	@JoinColumn(name="KUNJUNGAN_ID", nullable=false, insertable=false, updatable=false)
	public KunjunganModel getKunjungan() {
		return kunjungan;
	}
	public void setKunjungan(KunjunganModel kunjungan) {
		this.kunjungan = kunjungan;
	}
	
}
