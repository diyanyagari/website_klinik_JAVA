package com.xsis.bootcamp.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="PROPINSI")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class PropinsiModel {
	private Integer id;
	private String nama;
	private Set<PasienModel> pasien;
	private Set<KotaModel> kotaModel;
	
	@Id
	@Column(name="PROPINSI_ID")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="PROPINSI")
	@TableGenerator(name="PROPINSI",table="SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="PROPINSI", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=1)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="NAMA_PROPINSI")
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="propinsi")
	public Set<PasienModel> getPasien() {
		return pasien;
	}
	public void setPasien(Set<PasienModel> pasien) {
		this.pasien = pasien;
	}
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="propinsi")
	public Set<KotaModel> getKotaModel() {
		return kotaModel;
	}
	public void setKotaModel(Set<KotaModel> kotaModel) {
		this.kotaModel = kotaModel;
	}	
	
}
