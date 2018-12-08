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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Naluem
 */
@Entity
@Table(name = "body_type", catalog = "fitnessapp", schema = "public")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
	@NamedQuery(name = "BodyType.findAll", query = "SELECT b FROM BodyType b"),
	@NamedQuery(name = "BodyType.findById", query = "SELECT b FROM BodyType b WHERE b.id = :id"),
	@NamedQuery(name = "BodyType.findByBodyTypeValue", query = "SELECT b FROM BodyType b WHERE b.bodyTypeValue = :bodyTypeValue")})
public class BodyType implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(nullable = false)
	private Integer id;
	@Basic(optional = false)
        @NotNull
        @Column(name = "body_type_value", nullable = false)
	private int bodyTypeValue;
	@OneToMany(mappedBy = "bodyTypeId", fetch = FetchType.EAGER)
        @XmlTransient
	private transient List<AdvancedWorkout> advancedWorkoutList;
	@OneToMany(mappedBy = "bodyTypeId", fetch = FetchType.EAGER)
        @XmlTransient
	private transient List<BasicWorkout> basicWorkoutList;
	@OneToMany(mappedBy = "bodyTypeId", fetch = FetchType.EAGER)
        @XmlTransient
	private transient List<Client> clientList;

	public BodyType() {
	}

	public BodyType(Integer id) {
		this.id = id;
	}

	public BodyType(Integer id, int bodyTypeValue) {
		this.id = id;
		this.bodyTypeValue = bodyTypeValue;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getBodyTypeValue() {
		return bodyTypeValue;
	}

	public void setBodyTypeValue(int bodyTypeValue) {
		this.bodyTypeValue = bodyTypeValue;
	}

	@XmlTransient
	public List<AdvancedWorkout> getAdvancedWorkoutList() {
		return advancedWorkoutList;
	}

	public void setAdvancedWorkoutList(List<AdvancedWorkout> advancedWorkoutList) {
		this.advancedWorkoutList = advancedWorkoutList;
	}

	@XmlTransient
	public List<BasicWorkout> getBasicWorkoutList() {
		return basicWorkoutList;
	}

	public void setBasicWorkoutList(List<BasicWorkout> basicWorkoutList) {
		this.basicWorkoutList = basicWorkoutList;
	}

	@XmlTransient
	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
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
		if (!(object instanceof BodyType)) {
			return false;
		}
		BodyType other = (BodyType) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.fitnessapp.entities.BodyType[ id=" + id + " ]";
	}
	
}
