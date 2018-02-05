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
@Table(name="DETAIL_RESEP")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class DetailResepModel {
	private Integer id;
	private Integer resepID;
	private Integer obatId;
	private Integer banyak;
	private String keterangan;
	private ResepModel resep;
	
	
	@Id
	@Column(name="DETAIL_RESEP_ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="DETAIL_RESEP_ID")
	@TableGenerator(name="DETAIL_RESEP_ID",table="SEQUENCE",pkColumnName="SEQUENCE_ID",pkColumnValue="DETAIL_RESEP_ID",valueColumnName="SEQUENCE_VALUE",allocationSize=0,initialValue=0)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="RESEP_ID")
	public Integer getResepID() {
		return resepID;
	}
	public void setResepID(Integer resepID) {
		this.resepID = resepID;
	}
	
	@Column(name="OBAT_ID")
	public Integer getObatId() {
		return obatId;
	}
	public void setObatId(Integer obatId) {
		this.obatId = obatId;
	}
	
	@Column(name="BANYAK")
	public Integer getBanyak() {
		return banyak;
	}
	public void setBanyak(Integer banyak) {
		this.banyak = banyak;
	}
	
	@Column(name="KETERANGAN")
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	
	@ManyToOne
	@JoinColumn(name="RESEP_ID", nullable=false, insertable=false, updatable=false)
	public ResepModel getResep() {
		return resep;
	}
	public void setResep(ResepModel resep) {
		this.resep = resep;
	}
		
}
