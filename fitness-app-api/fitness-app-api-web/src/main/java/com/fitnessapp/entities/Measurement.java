/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitnessapp.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Naluem
 */
@Entity
@Table(catalog = "fitness-app", schema = "public")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Measurement.findAll", query = "SELECT m FROM Measurement m"),
	@NamedQuery(name = "Measurement.findById", query = "SELECT m FROM Measurement m WHERE m.id = :id"),
	@NamedQuery(name = "Measurement.findByChestSize", query = "SELECT m FROM Measurement m WHERE m.chestSize = :chestSize"),
	@NamedQuery(name = "Measurement.findByWaistSize", query = "SELECT m FROM Measurement m WHERE m.waistSize = :waistSize"),
	@NamedQuery(name = "Measurement.findByThighSize", query = "SELECT m FROM Measurement m WHERE m.thighSize = :thighSize"),
	@NamedQuery(name = "Measurement.findByBottocksSize", query = "SELECT m FROM Measurement m WHERE m.bottocksSize = :bottocksSize"),
	@NamedQuery(name = "Measurement.findByArmSize", query = "SELECT m FROM Measurement m WHERE m.armSize = :armSize")})
public class Measurement implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(nullable = false)
	private Integer id;
	@Basic(optional = false)
        @NotNull
        @Column(name = "chest_size", nullable = false)
	private BigInteger chestSize;
	@Basic(optional = false)
        @NotNull
        @Column(name = "waist_size", nullable = false)
	private BigInteger waistSize;
	@Basic(optional = false)
        @NotNull
        @Column(name = "thigh_size", nullable = false)
	private BigInteger thighSize;
	@Basic(optional = false)
        @NotNull
        @Column(name = "bottocks_size", nullable = false)
	private BigInteger bottocksSize;
	@Basic(optional = false)
        @NotNull
        @Column(name = "arm_size", nullable = false)
	private BigInteger armSize;
	@JoinColumn(name = "client_id", referencedColumnName = "id")
        @ManyToOne(fetch = FetchType.EAGER)
	private Client clientId;

	public Measurement() {
	}

	public Measurement(Integer id) {
		this.id = id;
	}

	public Measurement(Integer id, BigInteger chestSize, BigInteger waistSize, BigInteger thighSize, BigInteger bottocksSize, BigInteger armSize) {
		this.id = id;
		this.chestSize = chestSize;
		this.waistSize = waistSize;
		this.thighSize = thighSize;
		this.bottocksSize = bottocksSize;
		this.armSize = armSize;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigInteger getChestSize() {
		return chestSize;
	}

	public void setChestSize(BigInteger chestSize) {
		this.chestSize = chestSize;
	}

	public BigInteger getWaistSize() {
		return waistSize;
	}

	public void setWaistSize(BigInteger waistSize) {
		this.waistSize = waistSize;
	}

	public BigInteger getThighSize() {
		return thighSize;
	}

	public void setThighSize(BigInteger thighSize) {
		this.thighSize = thighSize;
	}

	public BigInteger getBottocksSize() {
		return bottocksSize;
	}

	public void setBottocksSize(BigInteger bottocksSize) {
		this.bottocksSize = bottocksSize;
	}

	public BigInteger getArmSize() {
		return armSize;
	}

	public void setArmSize(BigInteger armSize) {
		this.armSize = armSize;
	}

	public Client getClientId() {
		return clientId;
	}

	public void setClientId(Client clientId) {
		this.clientId = clientId;
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
		if (!(object instanceof Measurement)) {
			return false;
		}
		Measurement other = (Measurement) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.fitnessapp.entities.Measurement[ id=" + id + " ]";
	}
	
}
