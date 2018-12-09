/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitnessapp.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Naluem
 */
@Entity
@Table(catalog = "fitnessapp", schema = "public", uniqueConstraints = {
	@UniqueConstraint(columnNames = {"user_name"})})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
	@NamedQuery(name = "Trainer.findAll", query = "SELECT t FROM Trainer t"),
	@NamedQuery(name = "Trainer.findById", query = "SELECT t FROM Trainer t WHERE t.id = :id"),
	@NamedQuery(name = "Trainer.findByUserName", query = "SELECT t FROM Trainer t WHERE t.userName = :userName"),
	@NamedQuery(name = "Trainer.findByUserPassword", query = "SELECT t FROM Trainer t WHERE t.userPassword = :userPassword"),
	@NamedQuery(name = "Trainer.findByMail", query = "SELECT t FROM Trainer t WHERE t.mail = :mail"),
	@NamedQuery(name = "Trainer.findByTelephone", query = "SELECT t FROM Trainer t WHERE t.telephone = :telephone"),
	@NamedQuery(name = "Trainer.findByAddress", query = "SELECT t FROM Trainer t WHERE t.address = :address")})
public class Trainer implements Serializable {

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
	@Size(max = 20)
        @Column(length = 20)
	private String telephone;
	@Size(max = 100)
        @Column(length = 100)
	private String address;
	@OneToMany(mappedBy = "trainerId", fetch = FetchType.EAGER)
        @XmlTransient
	private transient List<CustomRoutine> customRoutineList;

	public Trainer() {
	}

	public Trainer(Integer id) {
		this.id = id;
	}

	public Trainer(Integer id, String userName) {
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@XmlTransient
	public List<CustomRoutine> getCustomRoutineList() {
		return customRoutineList;
	}

	public void setCustomRoutineList(List<CustomRoutine> customRoutineList) {
		this.customRoutineList = customRoutineList;
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
		if (!(object instanceof Trainer)) {
			return false;
		}
		Trainer other = (Trainer) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.fitnessapp.entities.Trainer[ id=" + id + " ]";
	}
	
}
