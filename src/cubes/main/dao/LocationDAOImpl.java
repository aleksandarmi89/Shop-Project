package cubes.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cubes.main.entity.Category;
import cubes.main.entity.Location;
@Repository
public class LocationDAOImpl implements LocationDAO {
	
	
	@Autowired
	SessionFactory sessionFactory;
	
    @Transactional
	@Override
	public List<Location> getLocationList() {
    	Session session=sessionFactory.getCurrentSession();
    	List<Location> list=session.createQuery("from Location", Location.class).getResultList();
		
		return list;
	}
    @Transactional
	@Override
	public void saveLocation(Location location) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(location);
	}
    @Transactional
	@Override
	public Location getByLocationId(int id) {
    	Session session=sessionFactory.getCurrentSession();
		Location l=session.get(Location.class, id);
		return l;
	}
    @Transactional
	@Override
	public void deleteLocation(int id) {
    	Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("delete Location l where l.id=:id");
		q.setParameter("id", id);
		q.executeUpdate();
	}

}
