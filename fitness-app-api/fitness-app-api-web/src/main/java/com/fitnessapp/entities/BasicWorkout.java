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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Naluem
 */
@Entity
@Table(name = "basic_workout", catalog = "fitnessapp", schema = "public")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "BasicWorkout.findAll", query = "SELECT b FROM BasicWorkout b"),
	@NamedQuery(name = "BasicWorkout.findById", query = "SELECT b FROM BasicWorkout b WHERE b.id = :id")})
public class BasicWorkout implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(nullable = false)
	private Integer id;
	@OneToMany(mappedBy = "basicWorkoutId", fetch = FetchType.EAGER)
	private List<BasicExercise> basicExerciseList;
	@JoinColumn(name = "body_type_id", referencedColumnName = "id")
        @ManyToOne(fetch = FetchType.EAGER)
	private BodyType bodyTypeId;

	public BasicWorkout() {
	}

	public BasicWorkout(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@XmlTransient
	public List<BasicExercise> getBasicExerciseList() {
		return basicExerciseList;
	}

	public void setBasicExerciseList(List<BasicExercise> basicExerciseList) {
		this.basicExerciseList = basicExerciseList;
	}

	public BodyType getBodyTypeId() {
		return bodyTypeId;
	}

	public void setBodyTypeId(BodyType bodyTypeId) {
		this.bodyTypeId = bodyTypeId;
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
		if (!(object instanceof BasicWorkout)) {
			return false;
		}
		BasicWorkout other = (BasicWorkout) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.fitnessapp.entities.BasicWorkout[ id=" + id + " ]";
	}
	
}