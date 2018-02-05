/**
 * 
 */
package com.xsis.bootcamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author sharkbit_
 *
 */

@Entity
@Table(name="TABLE_USER")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class UserModel {
	private Integer id;
	private String namaUser;
	private String username;
	private String password;
	private Integer roleId;
	private RoleModel role;
	
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="TABLE_USER")
	@TableGenerator(name="TABLE_USER", table="SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="TABLE_USER", valueColumnName="SEQUENCE_VALUE", allocationSize=0, initialValue=0)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="NAMA_USER")
	public String getNamaUser() {
		return namaUser;
	}
	public void setNamaUser(String namaUser) {
		this.namaUser = namaUser;
	}
	
	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="ROLE_ID")
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	@Column(name="USERNAME")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ROLE_ID",nullable=false, insertable=false,updatable=false)
	public RoleModel getRole() {
		return role;
	}
	public void setRole(RoleModel role) {
		this.role = role;
	}
	
}
