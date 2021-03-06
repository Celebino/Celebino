package org.celebino.persistence.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.celebino.persistence.dao.GardenDao;
import org.celebino.persistence.dao.GardenStatusDao;
import org.celebino.persistence.model.Garden;
import org.celebino.persistence.model.GardenStatus;

@Path("gardenstatus")
public class GardenStatusController {
	
	
	/**
	 * Cadastra GardenStatus
	 * 
	 * @param GardenStatus
	 * @return Response
	 */
	@PermitAll
	@POST
	@Path("/")
	@Consumes("application/json")
	@Produces("application/json")
	public Response insert(GardenStatus gardenStatus) {
		
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());
		
		try {
			
			Long idGardenStatus = (long) GardenStatusDao.getInstance().insert(gardenStatus);
			gardenStatus.setId(idGardenStatus);
			builder.status(Response.Status.OK).entity(gardenStatus);
		
		} catch (SQLException e) {
			
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}
		
		return builder.build();
	}
	
	/**
	 * retorna todos os gardenstatus.
	 * 
	 * @return Response
	 */
	@PermitAll
	@GET
	@Path("/")
	@Produces("application/json")
	public List<GardenStatus> getAll() {
		
		
		List<GardenStatus> gardenstatus = new ArrayList<GardenStatus>();
		
		try {
			
			gardenstatus = GardenStatusDao.getInstance().getAll();
		
		} catch (SQLException e) {
			//TRATAR EXCECAO
		}
		
		return gardenstatus;
	}
	
	/**
	 * Retorna gardenstatus atraves do Id
	 * 
	 * @param idGardenStatus
	 * @return Response
	 */
	@PermitAll
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getGardenStatusById(@PathParam("id") Long idGardenStatus) {
		
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {
			
			GardenStatus gardenStatus = GardenStatusDao.getInstance().getById(idGardenStatus); 
			
			if (gardenStatus != null) {
				
				builder.status(Response.Status.OK);
				builder.entity(gardenStatus);
				
			} else {
				
				builder.status(Response.Status.NOT_FOUND);
			}

		} catch (SQLException exception) {

			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		return builder.build();
	}
	
	/**
	 * Get garden status by garden's id
	 * @param gardenId
	 * @return
	 */
	@PermitAll
	@GET
	@Path("/garden/{gardenId}")
	@Produces("application/json")
	public Response getGardensByGardenId(@PathParam("gardenId") Long gardenId) {

		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {
			
			List<GardenStatus> gardenStatus = GardenStatusDao.getInstance().getByGardenId(gardenId); 
			
			if (gardenStatus != null) {
				
				builder.status(Response.Status.OK);
				builder.entity(gardenStatus);	
			} else {
				
				builder.status(Response.Status.NOT_FOUND);
			}

		} catch (SQLException exception) {

			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		return builder.build();
	}
	
}
