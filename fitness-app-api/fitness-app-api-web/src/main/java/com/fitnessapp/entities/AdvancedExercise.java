/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitnessapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "advanced_exercise", catalog = "fitnessapp", schema = "public",uniqueConstraints = {
    @UniqueConstraint(columnNames = {"exercise_name"})
})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
	@NamedQuery(name = "AdvancedExercise.findAll", query = "SELECT a FROM AdvancedExercise a"),
	@NamedQuery(name = "AdvancedExercise.findById", query = "SELECT a FROM AdvancedExercise a WHERE a.id = :id"),
	@NamedQuery(name = "AdvancedExercise.findByExerciseName", query = "SELECT a FROM AdvancedExercise a WHERE a.exerciseName = :exerciseName"),
	@NamedQuery(name = "AdvancedExercise.findByDescription", query = "SELECT a FROM AdvancedExercise a WHERE a.description = :description"),
	@NamedQuery(name = "AdvancedExercise.findByExerciseSets", query = "SELECT a FROM AdvancedExercise a WHERE a.exerciseSets = :exerciseSets"),
	@NamedQuery(name = "AdvancedExercise.findByRepetitions", query = "SELECT a FROM AdvancedExercise a WHERE a.repetitions = :repetitions"),
        @NamedQuery(name = "AdvancedExercise.findByMuscularGroupId", query = "SELECT a FROM AdvancedExercise a WHERE a.muscularGroupId.id = :id"),
})
public class AdvancedExercise implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(nullable = false)
	private Integer id;
	@Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 200)
        @Column(name = "exercise_name", nullable = false, length = 200)
	private String exerciseName;
	@Size(max = 500)
        @Column(length = 500)
	private String description;
	@Basic(optional = false)
        @NotNull
        @Column(name = "exercise_sets", nullable = false)
	private int exerciseSets;
	@Basic(optional = false)
        @NotNull
        @Column(nullable = false)
	private int repetitions;
        
        private Float kcal;

        @ManyToMany(fetch = FetchType.LAZY, mappedBy = "advancedExercises")
        @XmlTransient
        private transient Set<DailyAdvancedWorkout> dailyAdvancedWorkouts = new HashSet<DailyAdvancedWorkout>(0);
        
	@JoinColumn(name = "muscular_group_id", referencedColumnName = "id")
        @ManyToOne(fetch = FetchType.EAGER)
	private MuscularGroup muscularGroupId;
	@OneToMany(mappedBy = "advancedExerciseId", fetch = FetchType.EAGER)
        @XmlTransient
	private transient List<AdvancedClientTracking> advancedClientTrackingList;
        
	public AdvancedExercise() {
	}

	public AdvancedExercise(Integer id) {
		this.id = id;
	}

	public AdvancedExercise(Integer id, String exerciseName, int exerciseSets, int repetitions) {
		this.id = id;
		this.exerciseName = exerciseName;
		this.exerciseSets = exerciseSets;
		this.repetitions = repetitions;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getExerciseSets() {
		return exerciseSets;
	}

	public void setExerciseSets(int exerciseSets) {
		this.exerciseSets = exerciseSets;
	}

	public int getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}

	public MuscularGroup getMuscularGroupId() {
		return muscularGroupId;
	}

	public void setMuscularGroupId(MuscularGroup muscularGroupId) {
		this.muscularGroupId = muscularGroupId;
	}

	@XmlTransient
	public List<AdvancedClientTracking> getAdvancedClientTrackingList() {
		return advancedClientTrackingList;
	}

	public void setAdvancedClientTrackingList(List<AdvancedClientTracking> advancedClientTrackingList) {
		this.advancedClientTrackingList = advancedClientTrackingList;
	}

        public Float getKcal() {
            return kcal;
        }

        public void setKcal(Float kcal) {
            this.kcal = kcal;
        }
        @XmlTransient
        public Set<DailyAdvancedWorkout> getdailyAdvancedWorkouts() {
            return dailyAdvancedWorkouts;
        }

        public void setdailyAdvancedWorkouts(Set<DailyAdvancedWorkout> dailyAdvancedWorkouts) {
            this.dailyAdvancedWorkouts = dailyAdvancedWorkouts;
        }

    public Set<DailyAdvancedWorkout> getDailyAdvancedWorkouts() {
        return dailyAdvancedWorkouts;
    }

    public void setDailyAdvancedWorkouts(Set<DailyAdvancedWorkout> dailyAdvancedWorkouts) {
        this.dailyAdvancedWorkouts = dailyAdvancedWorkouts;
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
		if (!(object instanceof AdvancedExercise)) {
			return false;
		}
		AdvancedExercise other = (AdvancedExercise) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.fitnessapp.entities.AdvancedExercise[ id=" + id + " ]";
	}
	
}
