/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitnessapp.service;

import com.fitnessapp.entities.Tag;
import com.fitnessapp.entities.Token;
import com.fitnessapp.utils.FCMNotification;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Naluem
 */
@Stateless
@Path("tag")
public class TagFacadeREST extends AbstractFacade<Tag> {

	@PersistenceContext(unitName = "fitnessapp_0.0.1PU")
	private EntityManager em;

	public TagFacadeREST() {
		super(Tag.class);
	}

	@POST
        @Override
        @Consumes({MediaType.APPLICATION_JSON})
	public void create(Tag entity) {
            super.create(entity);
            TypedQuery<Token> consultaTokens = em.createNamedQuery("Token.findAll", Token.class);
            List<Token> tokens = consultaTokens.getResultList();
            FCMNotification obj = new FCMNotification();
            for(Token t : tokens){
                try {
                    obj.pushFCMNotification(t.getToken());
                } catch (Exception ex) {
                    Logger.getLogger(TagFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
	}

	@PUT
        @Path("{id}")
        @Consumes({MediaType.APPLICATION_JSON})
	public void edit(@PathParam("id") Integer id, Tag entity) {
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
	public Tag find(@PathParam("id") Integer id) {
		return super.find(id);
	}

	@GET
        @Override
        @Produces({MediaType.APPLICATION_JSON})
	public List<Tag> findAll() {
		return super.findAll();
	}

	@GET
        @Path("{from}/{to}")
        @Produces({MediaType.APPLICATION_JSON})
	public List<Tag> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
		return super.findRange(new int[]{from, to});
	}

        @GET
        @Path("findByName/{tagName}")
        @Produces({MediaType.APPLICATION_JSON})
        public List<Tag> findByTagName(@PathParam("tagName") String tagName){
            TypedQuery<Tag> consultaTag = this.em.createNamedQuery("Tag.findByTagName", Tag.class);
            consultaTag.setParameter("tagName", tagName);
            return consultaTag.getResultList();
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
