/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitnessapp.service;

import com.fitnessapp.entities.Administrator;
import com.fitnessapp.entities.AdvancedExercise;
import com.fitnessapp.entities.DailyAdvancedWorkout;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Naluem
 */
@Stateless
@Path("dailyadvancedworkout")
public class DailyAdvancedWorkoutFacadeREST extends AbstractFacade<DailyAdvancedWorkout> {

	@PersistenceContext(unitName = "fitnessapp_0.0.1PU")
	private EntityManager em;

	public DailyAdvancedWorkoutFacadeREST() {
		super(DailyAdvancedWorkout.class);
	}

	@POST
        @Override
        @Consumes({MediaType.APPLICATION_JSON})
	public void create(DailyAdvancedWorkout entity) {
		super.create(entity);
	}

	@PUT
        @Path("{id}")
        @Consumes({MediaType.APPLICATION_JSON})
	public void edit(@PathParam("id") Integer id, DailyAdvancedWorkout entity) {
		super.edit(entity);
	}

	@DELETE
        @Path("{id}")
	public void remove(@PathParam("id") Integer id) {
		super.remove(super.find(id));
	}

	@GET
        @Path("{id}")
        @Produces({MediaType.APPLICATION_JSON})
	public DailyAdvancedWorkout find(@PathParam("id") Integer id) {
		return super.find(id);
	}

	@GET
        @Override
        @Produces({MediaType.APPLICATION_JSON})
	public List<DailyAdvancedWorkout> findAll() {
		return super.findAll();
	}

	@GET
        @Path("{from}/{to}")
        @Produces({MediaType.APPLICATION_JSON})
	public List<DailyAdvancedWorkout> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
		return super.findRange(new int[]{from, to});
	}

	@GET
        @Path("count")
        @Produces(MediaType.TEXT_PLAIN)
	public String countREST() {
		return String.valueOf(super.count());
	}
        
        @GET
        @Path("findByAdvancedWorkoutId/{id}")
        @Produces({MediaType.APPLICATION_JSON})
        public List<DailyAdvancedWorkout> findByAdvancedWorkoutId(@PathParam("id") String id) {
            EntityManagerFactory emf
                    = Persistence.createEntityManagerFactory("fitnessapp_0.0.1PU");
            EntityManager em = emf.createEntityManager();
            TypedQuery<DailyAdvancedWorkout> consultaDailyAdvancedWorkout = em.createNamedQuery("DailyAdvancedWorkout.findByAdvancedWorkoutId", DailyAdvancedWorkout.class);
            consultaDailyAdvancedWorkout.setParameter("id", Integer.parseInt(id));
            return consultaDailyAdvancedWorkout.getResultList();
        }
        
        @GET
        @Path("findDailyExercises/{id}")
        @Produces({MediaType.APPLICATION_JSON})
        public List<DailyAdvancedWorkout> findDailyExercises(@PathParam("id") int id) {
            EntityManagerFactory emf
                    = Persistence.createEntityManagerFactory("fitnessapp_0.0.1PU");
            EntityManager em = emf.createEntityManager();
            TypedQuery<DailyAdvancedWorkout> consultaAdvancedExercise = em.createNamedQuery("DailyAdvancedWorkout.findDailyExercises", DailyAdvancedWorkout.class);
            consultaAdvancedExercise.setParameter("id", id);
            return consultaAdvancedExercise.getResultList();
        }
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
}
