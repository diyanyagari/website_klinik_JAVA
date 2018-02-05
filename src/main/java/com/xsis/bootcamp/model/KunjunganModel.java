package com.xsis.bootcamp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="KUNJUNGAN")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class KunjunganModel {
	private Integer id;
	private Integer dokterId;
	private Integer pasienId;
	private String tglKunjung;
	private Integer totalBiaya;
	private String keluhan;
	private String status;
	private List<DetailKunjunganModel> detailKunjungans;
	
	@Id
	@Column(name="KUNJUNGAN_ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="KUNJUNGAN")
	@TableGenerator(name="KUNJUNGAN",table="SEQUENCE", pkColumnName="SEQUENCE_ID",pkColumnValue="KUNJUNGAN", valueColumnName="SEQUENCE_VALUE",allocationSize=0,initialValue=0)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="DOKTER_ID")
	public Integer getDokterId() {
		return dokterId;
	}
	public void setDokterId(Integer dokterId) {
		this.dokterId = dokterId;
	}
	
	@Column(name="PASIEN_ID")
	public Integer getPasienId() {
		return pasienId;
	}
	public void setPasienId(Integer pasienId) {
		this.pasienId = pasienId;
	}
	
	@Column(name="TANGGAL_KUNJUNGAN")
	public String getTglKunjung() {
		return tglKunjung;
	}
	public void setTglKunjung(String tglKunjung) {
		this.tglKunjung = tglKunjung;
	}
	
	@Column(name="TOTAL_BIAYA")
	public Integer getTotalBiaya() {
		return totalBiaya;
	}
	public void setTotalBiaya(Integer totalBiaya) {
		this.totalBiaya = totalBiaya;
	}
	
	@Column(name="KELUHAN")	
	public String getKeluhan() {
		return keluhan;
	}
	public void setKeluhan(String keluhan) {
		this.keluhan = keluhan;
	}
	
	@Column(name="STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@OneToMany(fetch= FetchType.EAGER, mappedBy="kunjungan")
	public List<DetailKunjunganModel> getDetailKunjungans() {
		return detailKunjungans;
	}
	public void setDetailKunjungans(List<DetailKunjunganModel> detailKunjungans) {
		this.detailKunjungans = detailKunjungans;
	}
	
	
}
