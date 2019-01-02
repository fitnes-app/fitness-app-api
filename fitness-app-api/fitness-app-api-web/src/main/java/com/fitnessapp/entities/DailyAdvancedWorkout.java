/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitnessapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Naluem
 */
@Entity
@Table(name = "daily_advanced_workout", catalog = "fitnessapp", schema = "public")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
	@NamedQuery(name = "DailyAdvancedWorkout.findAll", query = "SELECT d FROM DailyAdvancedWorkout d"),
	@NamedQuery(name = "DailyAdvancedWorkout.findById", query = "SELECT d FROM DailyAdvancedWorkout d WHERE d.id = :id"),
        @NamedQuery(name = "DailyAdvancedWorkout.findByAdvancedWorkoutId", query = "SELECT d FROM DailyAdvancedWorkout d WHERE d.advancedWorkoutId.id = :id")
})
public class DailyAdvancedWorkout implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(nullable = false)
	private Integer id;
        
        private Integer week_day;
        
	@JoinColumn(name = "advanced_workout_id", referencedColumnName = "id")
        @ManyToOne(fetch = FetchType.EAGER)
	private AdvancedWorkout advancedWorkoutId;

        @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinTable(name = "adv_daily_exercise_assign", joinColumns = {
        @JoinColumn(name = "adv_workout_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "adv_exercise_id",
                        nullable = false, updatable = false)})
        
        private  Set<AdvancedExercise> advancedExercises = new HashSet<AdvancedExercise>(0);
        
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

        public Integer getWeek_day() {
            return week_day;
        }

        public void setWeek_day(Integer week_day) {
            this.week_day = week_day;
        }

        
        public Set<AdvancedExercise> getAdvancedExercises() {
            return advancedExercises;
        }

        public void setAdvancedExercises(Set<AdvancedExercise> advancedExercise) {
            this.advancedExercises = advancedExercise;
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
