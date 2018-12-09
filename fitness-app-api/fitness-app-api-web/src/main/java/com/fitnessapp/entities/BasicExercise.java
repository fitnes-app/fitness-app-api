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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "basic_exercise", catalog = "fitnessapp", schema = "public")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
	@NamedQuery(name = "BasicExercise.findAll", query = "SELECT b FROM BasicExercise b"),
	@NamedQuery(name = "BasicExercise.findById", query = "SELECT b FROM BasicExercise b WHERE b.id = :id"),
	@NamedQuery(name = "BasicExercise.findByExerciseName", query = "SELECT b FROM BasicExercise b WHERE b.exerciseName = :exerciseName"),
	@NamedQuery(name = "BasicExercise.findByDescription", query = "SELECT b FROM BasicExercise b WHERE b.description = :description"),
	@NamedQuery(name = "BasicExercise.findByExerciseSets", query = "SELECT b FROM BasicExercise b WHERE b.exerciseSets = :exerciseSets"),
	@NamedQuery(name = "BasicExercise.findByRepetitions", query = "SELECT b FROM BasicExercise b WHERE b.repetitions = :repetitions")})
public class BasicExercise implements Serializable {

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
	@OneToMany(mappedBy = "basicExerciseId", fetch = FetchType.EAGER)
        @XmlTransient
	private transient List<BasicClientTracking> basicClientTrackingList;
	@JoinColumn(name = "basic_workout_id", referencedColumnName = "id")
        @ManyToOne(fetch = FetchType.EAGER)
	private BasicWorkout basicWorkoutId;
	@JoinColumn(name = "muscular_group_id", referencedColumnName = "id")
        @ManyToOne(fetch = FetchType.EAGER)
	private MuscularGroup muscularGroupId;

	public BasicExercise() {
	}

	public BasicExercise(Integer id) {
		this.id = id;
	}

	public BasicExercise(Integer id, String exerciseName, int exerciseSets, int repetitions) {
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

	@XmlTransient
	public List<BasicClientTracking> getBasicClientTrackingList() {
		return basicClientTrackingList;
	}

	public void setBasicClientTrackingList(List<BasicClientTracking> basicClientTrackingList) {
		this.basicClientTrackingList = basicClientTrackingList;
	}

	public BasicWorkout getBasicWorkoutId() {
		return basicWorkoutId;
	}

	public void setBasicWorkoutId(BasicWorkout basicWorkoutId) {
		this.basicWorkoutId = basicWorkoutId;
	}

	public MuscularGroup getMuscularGroupId() {
		return muscularGroupId;
	}

	public void setMuscularGroupId(MuscularGroup muscularGroupId) {
		this.muscularGroupId = muscularGroupId;
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
		if (!(object instanceof BasicExercise)) {
			return false;
		}
		BasicExercise other = (BasicExercise) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.fitnessapp.entities.BasicExercise[ id=" + id + " ]";
	}
	
}
