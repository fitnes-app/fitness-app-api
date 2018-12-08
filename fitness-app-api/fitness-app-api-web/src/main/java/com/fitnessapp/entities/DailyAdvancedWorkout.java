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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Naluem
 */
@Entity
@Table(name = "daily_advanced_workout", catalog = "fitnessapp", schema = "public")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "DailyAdvancedWorkout.findAll", query = "SELECT d FROM DailyAdvancedWorkout d"),
	@NamedQuery(name = "DailyAdvancedWorkout.findById", query = "SELECT d FROM DailyAdvancedWorkout d WHERE d.id = :id")})
public class DailyAdvancedWorkout implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(nullable = false)
	private Integer id;
	@JoinColumn(name = "advanced_workout_id", referencedColumnName = "id")
        @ManyToOne(fetch = FetchType.EAGER)
	private AdvancedWorkout advancedWorkoutId;

	public DailyAdvancedWorkout() {
	}

	public DailyAdvancedWorkout(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AdvancedWorkout getAdvancedWorkoutId() {
		return advancedWorkoutId;
	}

	public void setAdvancedWorkoutId(AdvancedWorkout advancedWorkoutId) {
		this.advancedWorkoutId = advancedWorkoutId;
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
		if (!(object instanceof DailyAdvancedWorkout)) {
			return false;
		}
		DailyAdvancedWorkout other = (DailyAdvancedWorkout) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.fitnessapp.entities.DailyAdvancedWorkout[ id=" + id + " ]";
	}
	
}
