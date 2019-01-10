/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitnessapp.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Naluem
 */
@Entity
@Table(name = "daily_tip", catalog = "fitnessapp", schema = "public")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "DailyTip.findAll", query = "SELECT d FROM DailyTip d"),
	@NamedQuery(name = "DailyTip.findById", query = "SELECT d FROM DailyTip d WHERE d.id = :id"),
	@NamedQuery(name = "DailyTip.findByText", query = "SELECT d FROM DailyTip d WHERE d.text = :text")})
public class DailyTip implements Serializable {

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

        @Temporal(TemporalType.DATE)
        @Column(nullable = false)
        private Date date;
        
	public DailyTip() {
	}

	public DailyTip(Integer id) {
		this.id = id;
	}

	public DailyTip(Integer id, String text) {
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

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
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
		if (!(object instanceof DailyTip)) {
			return false;
		}
		DailyTip other = (DailyTip) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.fitnessapp.entities.DailyTip[ id=" + id + " ]";
	}
	
}