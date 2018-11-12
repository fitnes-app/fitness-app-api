/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitnessapp.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Naluem
 */
@Entity
@Table(catalog = "fitness-app", schema = "public", uniqueConstraints = {
	@UniqueConstraint(columnNames = {"user_name"})})
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Administrator.findAll", query = "SELECT a FROM Administrator a"),
	@NamedQuery(name = "Administrator.findById", query = "SELECT a FROM Administrator a WHERE a.id = :id"),
	@NamedQuery(name = "Administrator.findByUserName", query = "SELECT a FROM Administrator a WHERE a.userName = :userName"),
	@NamedQuery(name = "Administrator.findByUserPassword", query = "SELECT a FROM Administrator a WHERE a.userPassword = :userPassword"),
	@NamedQuery(name = "Administrator.findByMail", query = "SELECT a FROM Administrator a WHERE a.mail = :mail")})
public class Administrator implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(nullable = false)
	private Integer id;
	@Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 100)
        @Column(name = "user_name", nullable = false, length = 100)
	private String userName;
	@Size(max = 500)
        @Column(name = "user_password", length = 500)
	private String userPassword;
	@Size(max = 200)
        @Column(length = 200)
	private String mail;

	public Administrator() {
	}

	public Administrator(Integer id) {
		this.id = id;
	}

	public Administrator(Integer id, String userName) {
		this.id = id;
		this.userName = userName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Administrator)) {
			return false;
		}
		Administrator other = (Administrator) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.fitnessapp.entities.Administrator[ id=" + id + " ]";
	}
	
}
