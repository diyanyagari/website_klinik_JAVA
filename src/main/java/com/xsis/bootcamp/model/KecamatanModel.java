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
@Table(name="KECAMATAN")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class KecamatanModel {
	private Integer id;
	private String nama;
	private Integer KotaId;
	private KotaModel kota;
	
	@Id
	@Column(name="KECAMATAN_ID")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="KECAMATAN")
	@TableGenerator(name="KECAMATAN",table="SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="KECAMATAN", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=1)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="KECAMATAN_NAME")
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	@Column(name="KOTA_ID")
	public Integer getKotaId() {
		return KotaId;
	}
	public void setKotaId(Integer kabupatenId) {
		this.KotaId = kabupatenId;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="KOTA_ID", nullable=false, insertable=false, updatable=false)
	public KotaModel getKota() {
		return kota;
	}
	public void setKota(KotaModel kota) {
		this.kota = kota;
	}
	
}
