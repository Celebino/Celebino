package org.celebino.persistence.dao;

import java.sql.SQLException;
import java.util.List;

import org.celebino.persistence.model.ArtificialLight;
import org.celebino.persistence.model.User;

public class ArtificialLightDao extends GenericDao<Long, ArtificialLight>{

	private static ArtificialLightDao instance;
	
	public static ArtificialLightDao getInstance() {		
		instance = new ArtificialLightDao();		
		return instance;
	}
	
	@Override
	public List<ArtificialLight> getAll() throws SQLException {
		return super.getAll("ArtificialLight.getAll");

	}

	@Override
	public Class<?> getEntityClass() {
		// TODO Auto-generated method stub
		return ArtificialLight.class;
	}

	@Override
	public ArtificialLight find(ArtificialLight entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
