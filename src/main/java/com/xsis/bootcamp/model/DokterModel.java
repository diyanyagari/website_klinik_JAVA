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
@Table(name="DOKTER")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class DokterModel {
	private Integer id;
	private String nama;
	private String alamat;
	private Integer kecamatanId;
	private Integer kotaId;
	private Integer propinsiId;
	
	@Id
	@Column(name="DOKTER_ID")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="DOKTER")
	@TableGenerator(name="DOKTER",table="SEQUENCE",pkColumnName="SEQUENCE_ID",pkColumnValue="DOKTER",valueColumnName="SEQUENCE_VALUE",allocationSize=0,initialValue=0)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="NAMA_DOKTER")
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
	
	@Column(name="KECAMATAN_ID")
	public Integer getKecamatanId() {
		return kecamatanId;
	}
	public void setKecamatanId(Integer kecamatanId) {
		this.kecamatanId = kecamatanId;
	}
	
	@Column(name="KOTA_ID")
	public Integer getKotaId() {
		return kotaId;
	}
	public void setKotaId(Integer kotaId) {
		this.kotaId = kotaId;
	}
	
	@Column(name="PROPINSI_ID")
	public Integer getPropinsiId() {
		return propinsiId;
	}
	public void setPropinsiId(Integer propinsiId) {
		this.propinsiId = propinsiId;
	}
	
}
