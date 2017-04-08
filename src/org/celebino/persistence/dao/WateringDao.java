package org.celebino.persistence.dao;

import java.sql.SQLException;
import java.util.List;

import org.celebino.persistence.model.Watering;

public class WateringDao extends GenericDao<Long, Watering> {

	private static WateringDao instance;
	
	public static WateringDao getInstance() {		
		instance = new WateringDao();		
		return instance;
	}
	
	@Override
	public List<Watering> getAll() throws SQLException {
		return super.getAll("Watering.getAll");

	}

	@Override
	public Class<?> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Watering find(Watering entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
