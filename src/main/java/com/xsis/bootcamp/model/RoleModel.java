/**
 * 
 */
package com.xsis.bootcamp.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author sharkbit_
 *
 */

@Entity
@Table(name="ROLE")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class RoleModel {
	private Integer id;
	private String namaRole;
	private String keterangan;
	private Set<UserModel> user;
	
	@Id
	@Column(name="ROLE_ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="ROLE")
	@TableGenerator(name="ROLE", table="SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="ROLE", valueColumnName="SEQUENCE_VALUE", allocationSize=0, initialValue=0)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="NAMA_ROLE")
	public String getNamaRole() {
		return namaRole;
	}
	public void setNamaRole(String namaRole) {
		this.namaRole = namaRole;
	}
	
	@Column(name="KETERANGAN")
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="role")
	public Set<UserModel> getUser() {
		return user;
	}
	public void setUser(Set<UserModel> user) {
		this.user = user;
	}
	
}
