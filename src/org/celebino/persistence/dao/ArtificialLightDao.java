package org.celebino.persistence.dao;

import java.sql.SQLException;
import java.util.List;

import org.celebino.persistence.hibernate.HibernateUtil;
import org.celebino.persistence.model.ArtificialLight;
import org.celebino.persistence.model.GardenStatus;
import org.celebino.persistence.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

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
	
	/**
	 * Get artificial lights by garden's id
	 * @param gardenId
	 * @return
	 * @throws SQLException
	 */
	public List<ArtificialLight> getByGardenId(Long gardenId) throws SQLException{

		Session session = HibernateUtil.getSessionFactory().openSession();

		List<ArtificialLight> artificialights = null;

		try {

			String hql = "from ArtificialLight as a" + " where a.garden.id like :gardenId";


			Query query = session.createQuery(hql);
			query.setParameter("gardenId",  gardenId);

			artificialights = (List<ArtificialLight>) query.list();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

			throw new SQLException(hibernateException);

		} finally {

			session.close();
		}

		return artificialights;
	} 

}
