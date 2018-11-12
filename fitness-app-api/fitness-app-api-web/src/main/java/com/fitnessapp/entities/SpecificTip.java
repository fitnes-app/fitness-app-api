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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Naluem
 */
@Entity
@Table(name = "specific_tip", catalog = "fitness-app", schema = "public")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "SpecificTip.findAll", query = "SELECT s FROM SpecificTip s"),
	@NamedQuery(name = "SpecificTip.findById", query = "SELECT s FROM SpecificTip s WHERE s.id = :id"),
	@NamedQuery(name = "SpecificTip.findByText", query = "SELECT s FROM SpecificTip s WHERE s.text = :text")})
public class SpecificTip implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(nullable = false)
	private Integer id;
	@Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 300)
        @Column(nullable = false, length = 300)
	private String text;
	@JoinColumn(name = "muscular_group_id", referencedColumnName = "id")
        @ManyToOne(fetch = FetchType.EAGER)
	private MuscularGroup muscularGroupId;

	public SpecificTip() {
	}

	public SpecificTip(Integer id) {
		this.id = id;
	}

	public SpecificTip(Integer id, String text) {
		this.id = id;
		this.text = text;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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
		if (!(object instanceof SpecificTip)) {
			return false;
		}
		SpecificTip other = (SpecificTip) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.fitnessapp.entities.SpecificTip[ id=" + id + " ]";
	}
	
}
