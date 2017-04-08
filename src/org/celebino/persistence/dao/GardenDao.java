package org.celebino.persistence.dao;

import java.sql.SQLException;
import java.util.List;

import org.celebino.persistence.model.Garden;

public class GardenDao extends GenericDao<Long, Garden> {

	private static GardenDao instance;
	
	public static GardenDao getInstance() {		
		instance = new GardenDao();		
		return instance;
	}
	
	@Override
	public List<Garden> getAll() throws SQLException {
		return super.getAll("Garden.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Garden find(Garden entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
