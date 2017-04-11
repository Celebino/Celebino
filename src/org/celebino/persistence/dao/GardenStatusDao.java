package org.celebino.persistence.dao;

import java.sql.SQLException;
import java.util.List;

import org.celebino.persistence.model.GardenStatus;
import org.celebino.persistence.model.User;

public class GardenStatusDao extends GenericDao<Long, GardenStatus>{
	
	private static GardenStatusDao instance;
	
	public static GardenStatusDao getInstance() {		
		instance = new GardenStatusDao();		
		return instance;
	}
	
	@Override
	public List<GardenStatus> getAll() throws SQLException {
		return super.getAll("GardenStatus.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		// TODO Auto-generated method stub
		return GardenStatus.class;
	}

	@Override
	public GardenStatus find(GardenStatus entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
