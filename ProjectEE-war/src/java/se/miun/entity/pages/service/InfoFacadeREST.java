/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.miun.entity.pages.service;

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
import se.miun.entity.pages.Info;

/**
 *
 * @author Kjek
 */
@Stateless
@Path("se.miun.entity.pages.info")
public class InfoFacadeREST extends AbstractFacade<Info> {

	@PersistenceContext(unitName = "ProjectEE-warPU")
	private EntityManager em;

	public InfoFacadeREST() {
		super(Info.class);
	}

	@POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void create(Info entity) {
		super.create(entity);
	}

	@PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void edit(@PathParam("id") Integer id, Info entity) {
		super.edit(entity);
	}

	@DELETE
    @Path("{id}")
	public void remove(@PathParam("id") Integer id) {
		super.remove(super.find(id));
	}

	@GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Info find(@PathParam("id") Integer id) {
		return super.find(id);
	}

	@GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Info> findAll() {
		return super.findAll();
	}

	@GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Info> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
