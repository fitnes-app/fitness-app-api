/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitnessapp.service;

import com.fitnessapp.entities.Trainer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
@Path("trainer")
public class TrainerFacadeREST extends AbstractFacade<Trainer> {

	@PersistenceContext(unitName = "fitnessapp_0.0.1PU")
	private EntityManager em;

	public TrainerFacadeREST() {
		super(Trainer.class);
	}

	@POST
        @Override
        @Consumes({MediaType.APPLICATION_JSON})
	public void create(Trainer entity) {
		super.create(entity);
	}

	@PUT
        @Path("{id}")
        @Consumes({MediaType.APPLICATION_JSON})
	public void edit(@PathParam("id") Integer id, Trainer entity) {
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
	public Trainer find(@PathParam("id") Integer id) {
		return super.find(id);
	}

	@GET
        @Override
        @Produces({MediaType.APPLICATION_JSON})
	public List<Trainer> findAll() {
		return super.findAll();
	}

	@GET
        @Path("{from}/{to}")
        @Produces({MediaType.APPLICATION_JSON})
	public List<Trainer> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
		return super.findRange(new int[]{from, to});
	}
        
                @GET
        @Path("findByEmail/{email}")
        @Produces({MediaType.APPLICATION_JSON})
        public List<Trainer> findByEmail(@PathParam("email") String email) {
            TypedQuery<Trainer> consultaTrainer = this.em.createNamedQuery("Trainer.findByMail", Trainer.class);
            consultaTrainer.setParameter("mail", email);
            return consultaTrainer.getResultList();
        }

	@GET
        @Path("count")
        @Produces(MediaType.TEXT_PLAIN)
	public String countREST() {
		return String.valueOf(super.count());
	}
        @GET
        @Path("findByEmail/{email}")
        @Produces({MediaType.APPLICATION_JSON})
        public List<Trainer> findByEmail(@PathParam("email") String email) {
            TypedQuery<Trainer> consultaTrainer = this.em.createNamedQuery("Trainer.findByMail", Trainer.class);
            consultaTrainer.setParameter("mail", email);
            return consultaTrainer.getResultList();
        }
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
}
