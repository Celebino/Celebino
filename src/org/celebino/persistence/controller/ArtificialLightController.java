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

import org.celebino.persistence.dao.ArtificialLightDao;
import org.celebino.persistence.dao.GardenStatusDao;
import org.celebino.persistence.model.ArtificialLight;
import org.celebino.persistence.model.GardenStatus;


@Path("artificialLight")
public class ArtificialLightController {
	
	/**
	 * Cadastra ArtificialLight
	 * 
	 * @param ArtificialLight
	 * @return Response
	 */
	@PermitAll
	@POST
	@Path("/")
	@Consumes("application/json")
	@Produces("application/json")
	public Response insert(ArtificialLight artificialLight) {
		
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());
		
		try {
			
			Long idArtificialLight = (long) ArtificialLightDao.getInstance().insert(artificialLight);
			artificialLight.setId(idArtificialLight);
			builder.status(Response.Status.OK).entity(artificialLight);
		
		} catch (SQLException e) {
			
			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}
		
		return builder.build();
	}
	
	/**
	 * retorna todos os artificialLights.
	 * 
	 * @return Response
	 */
	@PermitAll
	@GET
	@Path("/")
	@Produces("application/json")
	public List<ArtificialLight> getAll() {
		
		
		List<ArtificialLight> artificialLights = new ArrayList<ArtificialLight>();
		
		try {
			
			artificialLights = ArtificialLightDao.getInstance().getAll();
		
		} catch (SQLException e) {
			//TRATAR EXCECAO
		}
		
		return artificialLights;
	}
	
	/**
	 * Retorna artificialLight atraves do Id
	 * 
	 * @param idArtificialLight
	 * @return Response
	 */
	@PermitAll
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getArtificialLightById(@PathParam("id") Long idArtificialLight) {
		
		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {
			
			ArtificialLight artificialLight = ArtificialLightDao.getInstance().getById(idArtificialLight); 
			
			if (artificialLight != null) {
				
				builder.status(Response.Status.OK);
				builder.entity(artificialLight);
				
			} else {
				
				builder.status(Response.Status.NOT_FOUND);
			}

		} catch (SQLException exception) {

			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		return builder.build();
	}
	
	/**
	 * Get artificial lights by garden's id
	 * @param gardenId
	 * @return
	 */
	@PermitAll
	@GET
	@Path("/garden/{gardenId}")
	@Produces("application/json")
	public Response getArtificialLightByGardenId(@PathParam("gardenId") Long gardenId) {

		ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
		builder.expires(new Date());

		try {
			
			List<ArtificialLight> artificialLights = ArtificialLightDao.getInstance().getByGardenId(gardenId); 
			
			if (artificialLights != null) {
				
				builder.status(Response.Status.OK);
				builder.entity(artificialLights);	
			} else {
				
				builder.status(Response.Status.NOT_FOUND);
			}

		} catch (SQLException exception) {

			builder.status(Response.Status.INTERNAL_SERVER_ERROR);
		}

		return builder.build();
	}
}
