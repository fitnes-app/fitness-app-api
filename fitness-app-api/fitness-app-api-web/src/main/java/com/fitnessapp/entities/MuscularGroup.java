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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Naluem
 */
@Entity
@Table(name = "muscular_group", catalog = "fitnessapp", schema = "public")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "MuscularGroup.findAll", query = "SELECT m FROM MuscularGroup m"),
	@NamedQuery(name = "MuscularGroup.findById", query = "SELECT m FROM MuscularGroup m WHERE m.id = :id"),
	@NamedQuery(name = "MuscularGroup.findByMuscularGroupName", query = "SELECT m FROM MuscularGroup m WHERE m.muscularGroupName = :muscularGroupName")})
public class MuscularGroup implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(nullable = false)
	private Integer id;
	@Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 100)
        @Column(name = "muscular_group_name", nullable = false, length = 100)
	private String muscularGroupName;
	@OneToMany(mappedBy = "muscularGroupId", fetch = FetchType.EAGER)
	private List<SpecificTip> specificTipList;
	@OneToMany(mappedBy = "muscularGroupId", fetch = FetchType.EAGER)
	private List<BasicExercise> basicExerciseList;
	@OneToMany(mappedBy = "muscularGroupId", fetch = FetchType.EAGER)
	private List<AdvancedExercise> advancedExerciseList;

	public MuscularGroup() {
	}

	public MuscularGroup(Integer id) {
		this.id = id;
	}

	public MuscularGroup(Integer id, String muscularGroupName) {
		this.id = id;
		this.muscularGroupName = muscularGroupName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMuscularGroupName() {
		return muscularGroupName;
	}

	public void setMuscularGroupName(String muscularGroupName) {
		this.muscularGroupName = muscularGroupName;
	}

	@XmlTransient
	public List<SpecificTip> getSpecificTipList() {
		return specificTipList;
	}

	public void setSpecificTipList(List<SpecificTip> specificTipList) {
		this.specificTipList = specificTipList;
	}

	@XmlTransient
	public List<BasicExercise> getBasicExerciseList() {
		return basicExerciseList;
	}

	public void setBasicExerciseList(List<BasicExercise> basicExerciseList) {
		this.basicExerciseList = basicExerciseList;
	}

	@XmlTransient
	public List<AdvancedExercise> getAdvancedExerciseList() {
		return advancedExerciseList;
	}

	public void setAdvancedExerciseList(List<AdvancedExercise> advancedExerciseList) {
		this.advancedExerciseList = advancedExerciseList;
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
		if (!(object instanceof MuscularGroup)) {
			return false;
		}
		MuscularGroup other = (MuscularGroup) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.fitnessapp.entities.MuscularGroup[ id=" + id + " ]";
	}
	
}
