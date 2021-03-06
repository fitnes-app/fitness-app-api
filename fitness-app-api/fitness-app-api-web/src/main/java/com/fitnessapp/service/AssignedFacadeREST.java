/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitnessapp.service;

import com.fitnessapp.entities.Assigned;
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
 * @author alex
 */
@Stateless
@Path("assigned")
public class AssignedFacadeREST extends AbstractFacade<Assigned> {

	@PersistenceContext(unitName = "fitnessapp_0.0.1PU")
	private EntityManager em;

	public AssignedFacadeREST() {
		super(Assigned.class);
	}

	@POST
        @Override
        @Consumes({MediaType.APPLICATION_JSON})
	public void create(Assigned entity) {
		super.create(entity);
	}

	@PUT
        @Path("{id}")
        @Consumes({MediaType.APPLICATION_JSON})
	public void edit(@PathParam("id") Integer id, Assigned entity) {
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
	public Assigned find(@PathParam("id") Integer id) {
		return super.find(id);
	}

	@GET
        @Override
        @Produces({MediaType.APPLICATION_JSON})
	public List<Assigned> findAll() {
		return super.findAll();
	}

	@GET
        @Path("{from}/{to}")
        @Produces({MediaType.APPLICATION_JSON})
	public List<Assigned> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
		return super.findRange(new int[]{from, to});
	}

        @GET
        @Path("findByClientId/{clientId}")
        @Produces({MediaType.APPLICATION_JSON})
        public List<Assigned> findByClientId(@PathParam("clientId") String clientId){
            TypedQuery<Assigned> consultaAssigned = this.em.createNamedQuery("Assigned.findByClientId", Assigned.class);
            consultaAssigned.setParameter("id", Integer.parseInt(clientId));
            return consultaAssigned.getResultList();
        }

        @GET
        @Path("findByTrainerId/{trainerId}")
        @Produces({MediaType.APPLICATION_JSON})
        public List<Assigned> findByTrainerId(@PathParam("trainerId") String trainerId) {
            TypedQuery<Assigned> consultaAssigned = this.em.createNamedQuery("Assigned.findByTrainerId", Assigned.class);
            consultaAssigned.setParameter("id", Integer.parseInt(trainerId));
            return consultaAssigned.getResultList();
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
