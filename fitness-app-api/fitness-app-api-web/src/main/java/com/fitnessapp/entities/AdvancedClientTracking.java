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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Naluem
 */
@Entity
@Table(name = "advanced_client_tracking", catalog = "fitnessapp", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdvancedClientTracking.findAll", query = "SELECT a FROM AdvancedClientTracking a"),
    @NamedQuery(name = "AdvancedClientTracking.findById", query = "SELECT a FROM AdvancedClientTracking a WHERE a.id = :id"),
    @NamedQuery(name = "AdvancedClientTracking.findByTrackingSets", query = "SELECT a FROM AdvancedClientTracking a WHERE a.trackingSets = :trackingSets"),
    @NamedQuery(name = "AdvancedClientTracking.findByRepetitions", query = "SELECT a FROM AdvancedClientTracking a WHERE a.repetitions = :repetitions"),
    @NamedQuery(name = "AdvancedClientTracking.findByClientId", query = "SELECT a FROM AdvancedClientTracking a WHERE a.clientId.id = :id"),
})
public class AdvancedClientTracking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tracking_sets", nullable = false)
    private int trackingSets;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int repetitions;
    @Basic(optional = false)
    @Column(name = "date")
    private String date;
    @Basic(optional = false)
    @Column(name = "kcal")
    private int kcal;
    @JoinColumn(name = "advanced_exercise_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private AdvancedExercise advancedExerciseId;
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Client clientId;

    public AdvancedClientTracking() {
    }

    public AdvancedClientTracking(Integer id) {
        this.id = id;
    }

    public AdvancedClientTracking(Integer id, int trackingSets, int repetitions) {
        this.id = id;
        this.trackingSets = trackingSets;
        this.repetitions = repetitions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTrackingSets() {
        return trackingSets;
    }

    public void setTrackingSets(int trackingSets) {
        this.trackingSets = trackingSets;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public AdvancedExercise getAdvancedExerciseId() {
        return advancedExerciseId;
    }

    public void setAdvancedExerciseId(AdvancedExercise advancedExerciseId) {
        this.advancedExerciseId = advancedExerciseId;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
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
        if (!(object instanceof AdvancedClientTracking)) {
            return false;
        }
        AdvancedClientTracking other = (AdvancedClientTracking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fitnessapp.entities.AdvancedClientTracking[ id=" + id + " ]";
    }

}
