/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitnessapp.service;

import com.fitnessapp.entities.DailyBasicWorkout;
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
 * @author Jordi
 */
@Stateless
@Path("dailybasicworkout")
public class DailyBasicWorkoutFacadeREST extends AbstractFacade<DailyBasicWorkout>{
    @PersistenceContext(unitName = "fitnessapp_0.0.1PU")
    private EntityManager em;

    public DailyBasicWorkoutFacadeREST() {
        super(DailyBasicWorkout.class);
    }
    
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(DailyBasicWorkout entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, DailyBasicWorkout entity) {
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
    public DailyBasicWorkout find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<DailyBasicWorkout> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<DailyBasicWorkout> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("findByBasicWorkoutId/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<DailyBasicWorkout> findByBasicWorkoutId(@PathParam("id") String id) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("fitnessapp_0.0.1PU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<DailyBasicWorkout> consultaDailyBasicWorkout = em.createNamedQuery("DailyBasicWorkout.findByBasicWorkoutId", DailyBasicWorkout.class);
        consultaDailyBasicWorkout.setParameter("id", Integer.parseInt(id));
        return consultaDailyBasicWorkout.getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
