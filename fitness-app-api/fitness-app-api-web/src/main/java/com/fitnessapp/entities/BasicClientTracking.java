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
@Table(name = "basic_client_tracking", catalog = "fitnessapp", schema = "public")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "BasicClientTracking.findAll", query = "SELECT b FROM BasicClientTracking b"),
	@NamedQuery(name = "BasicClientTracking.findById", query = "SELECT b FROM BasicClientTracking b WHERE b.id = :id"),
	@NamedQuery(name = "BasicClientTracking.findByTrackingSets", query = "SELECT b FROM BasicClientTracking b WHERE b.trackingSets = :trackingSets"),
	@NamedQuery(name = "BasicClientTracking.findByRepetitions", query = "SELECT b FROM BasicClientTracking b WHERE b.repetitions = :repetitions")})
public class BasicClientTracking implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(nullable = false)
	private Integer id;
	@Basic(optional = false)
        @NotNull
        @Column(name = "tracking_sets", nullable = false)
	private int trackingSets;
	@Basic(optional = false)
        @NotNull
        @Column(nullable = false)
	private int repetitions;
	@JoinColumn(name = "basic_exercise_id", referencedColumnName = "id")
        @ManyToOne(fetch = FetchType.EAGER)
	private BasicExercise basicExerciseId;
	@JoinColumn(name = "client_id", referencedColumnName = "id")
        @ManyToOne(fetch = FetchType.EAGER)
	private Client clientId;

	public BasicClientTracking() {
	}

	public BasicClientTracking(Integer id) {
		this.id = id;
	}

	public BasicClientTracking(Integer id, int trackingSets, int repetitions) {
		this.id = id;
		this.trackingSets = trackingSets;
		this.repetitions = repetitions;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getTrackingSets() {
		return trackingSets;
	}

	public void setTrackingSets(int trackingSets) {
		this.trackingSets = trackingSets;
	}

	public int getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}

	public BasicExercise getBasicExerciseId() {
		return basicExerciseId;
	}

	public void setBasicExerciseId(BasicExercise basicExerciseId) {
		this.basicExerciseId = basicExerciseId;
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
		if (!(object instanceof BasicClientTracking)) {
			return false;
		}
		BasicClientTracking other = (BasicClientTracking) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.fitnessapp.entities.BasicClientTracking[ id=" + id + " ]";
	}
	
}
