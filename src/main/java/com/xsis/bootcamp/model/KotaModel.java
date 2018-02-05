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
@Table(name="KOTA")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class KotaModel {
	private Integer id;
	private String nama;
	private Integer propinsiId;
	private PropinsiModel propinsi;
	
	@Id
	@Column(name="KOTA_ID")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="KOTA")
	@TableGenerator(name="KOTA",table="SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="KABUPATEN", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=1)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="KOTA_NAME")
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	@Column(name="PROPINSI_ID")
	public Integer getPropinsiId() {
		return propinsiId;
	}
	public void setPropinsiId(Integer propinsiId) {
		this.propinsiId = propinsiId;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PROPINSI_ID", nullable=false, insertable=false, updatable=false)
	public PropinsiModel getPropinsi() {
		return propinsi;
	}
	public void setPropinsi(PropinsiModel propinsi) {
		this.propinsi = propinsi;
	}
	
	
	
}
