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
@Table(catalog = "fitnessapp", schema = "public", uniqueConstraints = {
	@UniqueConstraint(columnNames = {"mail"})})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
	@NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
	@NamedQuery(name = "Client.findById", query = "SELECT c FROM Client c WHERE c.id = :id"),
	@NamedQuery(name = "Client.findByUserName", query = "SELECT c FROM Client c WHERE c.userName = :userName"),
	@NamedQuery(name = "Client.findByUserPassword", query = "SELECT c FROM Client c WHERE c.userPassword = :userPassword"),
	@NamedQuery(name = "Client.findByMail", query = "SELECT c FROM Client c WHERE c.mail = :mail"),
	@NamedQuery(name = "Client.findByWeight", query = "SELECT c FROM Client c WHERE c.weight = :weight"),
	@NamedQuery(name = "Client.findByHeight", query = "SELECT c FROM Client c WHERE c.height = :height"),
	@NamedQuery(name = "Client.findByTelephone", query = "SELECT c FROM Client c WHERE c.telephone = :telephone"),
	@NamedQuery(name = "Client.findByAddress", query = "SELECT c FROM Client c WHERE c.address = :address")})
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(nullable = false)
	private Integer id;
	@Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 100)
        @Column(name = "user_name", nullable = false, length = 100)
	private String userName;
	@Size(max = 500)
        @Column(name = "user_password", length = 500)
	private String userPassword;
	@Size(max = 200)
        @Column(length = 200)
	private String mail;
	@Basic(optional = false)
        @NotNull
        @Column(nullable = false)
	private Float weight;
	@Basic(optional = false)
        @NotNull
        @Column(nullable = false)
	private Float height;
	@Size(max = 20)
        @Column(length = 20)
	private String telephone;
	@Size(max = 100)
        @Column(length = 100)
	private String address;
	@OneToMany(mappedBy = "clientId", fetch = FetchType.EAGER)
        @XmlTransient
	private transient List<CustomRoutine> customRoutineList;
	@OneToMany(mappedBy = "clientId", fetch = FetchType.EAGER)
        @XmlTransient
	private transient List<BasicClientTracking> basicClientTrackingList;
	@OneToMany(mappedBy = "clientId", fetch = FetchType.EAGER)
        @XmlTransient
	private transient List<Measurement> measurementList;
	@OneToMany(mappedBy = "clientId", fetch = FetchType.EAGER)
        @XmlTransient
	private transient List<Answer> answerList;
	@JoinColumn(name = "body_type_id", referencedColumnName = "id")
        @ManyToOne(fetch = FetchType.EAGER)
	private BodyType bodyTypeId;
	@OneToMany(mappedBy = "clientId", fetch = FetchType.EAGER)
        @XmlTransient
	private transient List<AdvancedClientTracking> advancedClientTrackingList;
        @JoinColumn(name = "advanced_workout_id", referencedColumnName = "id")
        @ManyToOne(fetch = FetchType.EAGER)
        private AdvancedWorkout advancedWorkout;

        @JoinColumn(name = "basic_workout_id", referencedColumnName = "id")
        @ManyToOne(fetch = FetchType.EAGER)
        private BasicWorkout basicWorkout;
        private boolean is_premium;
        
	public Client() {
	}

	public Client(Integer id) {
		this.id = id;
	}

	public Client(Integer id, String userName, Float weight, Float height) {
		this.id = id;
		this.userName = userName;
		this.weight = weight;
		this.height = height;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@XmlTransient
	public List<CustomRoutine> getCustomRoutineList() {
		return customRoutineList;
	}

	public void setCustomRoutineList(List<CustomRoutine> customRoutineList) {
		this.customRoutineList = customRoutineList;
	}

	@XmlTransient
	public List<BasicClientTracking> getBasicClientTrackingList() {
		return basicClientTrackingList;
	}

	public void setBasicClientTrackingList(List<BasicClientTracking> basicClientTrackingList) {
		this.basicClientTrackingList = basicClientTrackingList;
	}

	@XmlTransient
	public List<Measurement> getMeasurementList() {
		return measurementList;
	}

	public void setMeasurementList(List<Measurement> measurementList) {
		this.measurementList = measurementList;
	}

	@XmlTransient
	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}

	public BodyType getBodyTypeId() {
		return bodyTypeId;
	}

	public void setBodyTypeId(BodyType bodyTypeId) {
		this.bodyTypeId = bodyTypeId;
	}

	@XmlTransient
	public List<AdvancedClientTracking> getAdvancedClientTrackingList() {
		return advancedClientTrackingList;
	}

	public void setAdvancedClientTrackingList(List<AdvancedClientTracking> advancedClientTrackingList) {
		this.advancedClientTrackingList = advancedClientTrackingList;
	}

        public AdvancedWorkout getAdvancedWorkout() {
            return advancedWorkout;
        }

        public void setAdvancedWorkout(AdvancedWorkout advancedWorkout) {
            this.advancedWorkout = advancedWorkout;
        }

        public BasicWorkout getBasicWorkout() {
            return basicWorkout;
        }

        public void setBasicWorkout(BasicWorkout basicWorkout) {
            this.basicWorkout = basicWorkout;
        }

        public boolean isIs_Premium() {
            return is_premium;
        }

        public void setIs_Premium(boolean isPremium) {
            this.is_premium = isPremium;
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
		if (!(object instanceof Client)) {
			return false;
		}
		Client other = (Client) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.fitnessapp.entities.Client[ id=" + id + " ]";
	}
	
}
