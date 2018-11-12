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
@Table(catalog = "fitness-app", schema = "public")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Answer.findAll", query = "SELECT a FROM Answer a"),
	@NamedQuery(name = "Answer.findById", query = "SELECT a FROM Answer a WHERE a.id = :id"),
	@NamedQuery(name = "Answer.findByText", query = "SELECT a FROM Answer a WHERE a.text = :text")})
public class Answer implements Serializable {

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
	@JoinColumn(name = "client_id", referencedColumnName = "id")
        @ManyToOne(fetch = FetchType.EAGER)
	private Client clientId;
	@JoinColumn(name = "question_id", referencedColumnName = "id")
        @ManyToOne(fetch = FetchType.EAGER)
	private Question questionId;

	public Answer() {
	}

	public Answer(Integer id) {
		this.id = id;
	}

	public Answer(Integer id, String text) {
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

	public Client getClientId() {
		return clientId;
	}

	public void setClientId(Client clientId) {
		this.clientId = clientId;
	}

	public Question getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Question questionId) {
		this.questionId = questionId;
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
		if (!(object instanceof Answer)) {
			return false;
		}
		Answer other = (Answer) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.fitnessapp.entities.Answer[ id=" + id + " ]";
	}
	
}
