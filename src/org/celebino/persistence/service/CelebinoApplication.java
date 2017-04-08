package org.celebino.persistence.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.apache.catalina.filters.CorsFilter;
import org.celebino.persistence.controller.ArtificialLightController;
import org.celebino.persistence.controller.GardenController;
import org.celebino.persistence.controller.GardenStatusController;
import org.celebino.persistence.controller.UserController;
import org.celebino.persistence.controller.WateringController;

public class CelebinoApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();

	public CelebinoApplication() {
		
		// Multiple client-request: Cross-Filter
		CorsFilter filter = new CorsFilter();
		filter.getAllowedOrigins().add("*");
		
			
		this.singletons.add(filter);
		
		// Controllers disponíveis no serviço.
		this.singletons.add(new UserController());
		this.singletons.add(new GardenController());
		this.singletons.add(new ArtificialLightController());
		this.singletons.add(new GardenStatusController());
		this.singletons.add(new WateringController());
	}

	public Set<Class<?>> getClasses() {
		return this.empty;
	}

	public Set<Object> getSingletons() {
		return this.singletons;
	}
}