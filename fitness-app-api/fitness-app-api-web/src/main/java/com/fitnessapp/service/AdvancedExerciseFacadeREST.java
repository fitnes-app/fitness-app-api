/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitnessapp.service;

import com.fitnessapp.entities.AdvancedExercise;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
@Path("advancedexercise")
public class AdvancedExerciseFacadeREST extends AbstractFacade<AdvancedExercise> {

	@PersistenceContext(unitName = "fitnessapp_0.0.1PU")
	private EntityManager em;

	public AdvancedExerciseFacadeREST() {
		super(AdvancedExercise.class);
	}

	@POST
        @Override
        @Consumes({MediaType.APPLICATION_JSON})
	public void create(AdvancedExercise entity) {
		super.create(entity);
	}

	@PUT
        @Path("{id}")
        @Consumes({MediaType.APPLICATION_JSON})
	public void edit(@PathParam("id") Integer id, AdvancedExercise entity) {
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
	public AdvancedExercise find(@PathParam("id") Integer id) {
		return super.find(id);
	}

	@GET
        @Override
        @Produces({MediaType.APPLICATION_JSON})
	public List<AdvancedExercise> findAll() {
		return super.findAll();
	}

	@GET
        @Path("{from}/{to}")
        @Produces({MediaType.APPLICATION_JSON})
	public List<AdvancedExercise> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
		return super.findRange(new int[]{from, to});
	}

	@GET
        @Path("count")
        @Produces(MediaType.TEXT_PLAIN)
	public String countREST() {
		return String.valueOf(super.count());
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
}
