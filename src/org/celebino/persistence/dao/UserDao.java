package org.celebino.persistence.dao;

import java.sql.SQLException;
import java.util.List;

import org.celebino.persistence.model.User;

public class UserDao extends GenericDao<Long, User> {

	private static UserDao instance;
	
	public static UserDao getInstance() {		
		instance = new UserDao();		
		return instance;
	}
	
	@Override
	public List<User> getAll() throws SQLException {
		return super.getAll("User.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User find(User entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
