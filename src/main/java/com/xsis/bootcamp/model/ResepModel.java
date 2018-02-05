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
@Table(name="RESEP")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class ResepModel {
	private Integer id;
	private Integer kunjunganId;
	private Integer pasienId;
	private Integer dokterId;
	private List<DetailResepModel> reseps;
		
	@Id
	@Column(name="RESEP_ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="RESEP")
	@TableGenerator(name="RESEP",table="SEQUENCE", pkColumnName="SEQUENCE_ID",pkColumnValue="RESEP", valueColumnName="SEQUENCE_VALUE",allocationSize=0,initialValue=0)
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
	
	@Column(name="PASIEN")
	public Integer getPasienId() {
		return pasienId;
	}
	public void setPasienId(Integer pasienId) {
		this.pasienId = pasienId;
	}
	
	@Column(name="DOKTER")
	public Integer getDokterId() {
		return dokterId;
	}
	public void setDokterId(Integer dokterId) {
		this.dokterId = dokterId;
	}
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="resep")
	public List<DetailResepModel> getReseps() {
		return reseps;
	}
	public void setReseps(List<DetailResepModel> reseps) {
		this.reseps = reseps;
	}
	
}
