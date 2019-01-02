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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jordi
 */
@Entity
@Table(name = "daily_basic_workout", catalog = "fitnessapp", schema = "public")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "DailyBasicWorkout.findAll", query = "SELECT d FROM DailyBasicWorkout d"),
    @NamedQuery(name = "DailyBasicWorkout.findById", query = "SELECT d FROM DailyBasicWorkout d WHERE d.id = :id"),
    @NamedQuery(name = "DailyBasicWorkout.findByBasicWorkoutId", query = "SELECT d FROM DailyBasicWorkout d WHERE d.basicWorkoutId.id = :id")
})
public class DailyBasicWorkout implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;

    private Integer week_day;

    @JoinColumn(name = "basic_workout_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private BasicWorkout basicWorkoutId;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "basic_daily_exercise_assign", joinColumns = {
        @JoinColumn(name = "basic_workout_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "basic_exercise_id",
                        nullable = false, updatable = false)})

    private Set<BasicExercise> basicExercises = new HashSet<BasicExercise>(0);

    public DailyBasicWorkout() {
    }

    public DailyBasicWorkout(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWeek_day() {
        return week_day;
    }

    public void setWeek_day(Integer week_day) {
        this.week_day = week_day;
    }

    public BasicWorkout getBasicWorkoutId() {
        return basicWorkoutId;
    }

    public void setBasicWorkoutId(BasicWorkout basicWorkoutId) {
        this.basicWorkoutId = basicWorkoutId;
    }

    public Set<BasicExercise> getBasicExercises() {
        return basicExercises;
    }

    public void setBasicExercises(Set<BasicExercise> basicExercises) {
        this.basicExercises = basicExercises;
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
        if (!(object instanceof DailyBasicWorkout)) {
            return false;
        }
        DailyBasicWorkout other = (DailyBasicWorkout) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fitnessapp.entities.DailyBasicWorkout[ id=" + id + " ]";
    }
}
