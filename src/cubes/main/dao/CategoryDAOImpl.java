package cubes.main.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cubes.main.entity.Category;
import cubes.main.service.CategoryService;
@Repository
public class CategoryDAOImpl implements CategoryDAO {
@Autowired
   private SessionFactory sessionFactory;
   
	@Override
	public List<Category> getCategoryList() {
		
		Session session=sessionFactory.getCurrentSession();
		
		List<Category> categories=session.createQuery("from Category",Category.class).getResultList();
		return categories;
	}
	
	@Override
	public void saveCategory(Category category) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(category);
		
	}
	
	@Override
	public Category getByCategoryId(Integer id) {
		if( id ==null||  id==0) {return null;}
		
		Session session=sessionFactory.getCurrentSession();
		Category cat=session.get(Category.class, id);
		return cat;
	}
	@Override
	public Category deleteCategory(int id) {
		Session session=sessionFactory.getCurrentSession();
		Category cat=session.get(Category.class, id);
		session.delete(cat);
		return cat;		
	}

	@Override
	public List<Category> getCategoryHomepageList() {
		
		Session session=sessionFactory.getCurrentSession();
		List<Category> categories=session.createQuery("from Category c where c.homepage=1",Category.class).getResultList();
		return categories;
	}

	@Override
	public int getCount(int id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("select count(*) from Product p where p.category.id =5");
		// query.setParameter("id", id);
		return (int) query.uniqueResult();
		
	}
	

}
