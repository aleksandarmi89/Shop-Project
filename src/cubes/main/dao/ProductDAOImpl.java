package cubes.main.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import cubes.main.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;
@Transactional
	@Override
	public List<Product> getProductList() {
		Session session=sessionFactory.getCurrentSession();
		List<Product> products=session.createQuery("from Product",Product.class).getResultList();
		for(Product p:products) {
			
			Hibernate.initialize(p.getStickers());}
		
		return products;
	}


@Transactional
@Override
public List<Product> getProductHomePage() {
	Session session=sessionFactory.getCurrentSession();
	List<Product> list=session.createQuery("from Product p where p.homepage=1",Product.class).getResultList();
	
	for(Product p:list) {
		
		Hibernate.initialize(p.getStickers());
	}
	 
	return list;
}
@Transactional
	@Override
	public void saveProduct(Product product) {
	Session session=sessionFactory.getCurrentSession();
	session.saveOrUpdate(product);
		
	}
@Transactional
	@Override
	public Product getByProductId(int id) {
	Session session=sessionFactory.getCurrentSession();
	Product pr=session.get(Product.class, id);
	
		
		Hibernate.initialize(pr.getStickers());
	return pr;
	}
@Transactional
	@Override
	public Product deleteProduct(int id) {
	Session session=sessionFactory.getCurrentSession();
	Product pr=session.get(Product.class, id);
	session.delete(pr);
	return pr;
	}

///-----------------------shop-----------------------------
@Transactional
@Override
public List<Product> getListProductBtCategoryId(int id) {
	
	
	Session session=sessionFactory.getCurrentSession();
	 
	String q="from Product p where p.category.id="+id;
	List<Product> list=session.createQuery(q,Product.class).getResultList();
	
	return list;
}

@Transactional
@Override
public List<Product> getProductList(Integer category,Integer price,Integer[]stickers) {
	Session session=sessionFactory.getCurrentSession();
	
	
	
	
	String queryString ="";
	
	if(stickers!=null) {
	
	 queryString = "select distinct p from Product p left join p.stickers s ";}
	else {queryString="from Product p ";}
	
	if (category!=null && category>0) {
		queryString = queryString + "where p.category.id=: categoryID";
		
	}
	
	if (price!=null && price>0) {
		
		if(!queryString.contains("where")) {
			
			queryString = queryString + "where ";
		}
		else {
			queryString = queryString + " and ";
		}
		
		queryString = queryString + " p.price <: price";
		
	}
	
if (stickers !=null && stickers.length>0) {
		
		if(!queryString.contains("where")) {
			
			queryString = queryString + "where ";
		}
		else {
			queryString = queryString + " and ";
		}
		queryString=queryString+ "s.id in (:stickers) ";
	}
	
	
	
	
	
	Query q = session.createQuery(queryString);
	
	if (category!=null && category>0) {
		q.setParameter("categoryID", category);
		
	}
	
	if (price!=null && price>0) {
		q.setParameter("price", (double)(price * 5000));
		
	}
	

	
	
	if(stickers!=null && stickers.length>0) {
		
			
		q.setParameterList("stickers", stickers);
	
		
	}
	
	List<Product> list=q.getResultList();
for(Product p:list) {
		
		Hibernate.initialize(p.getStickers());
	}
	 

	
	return list;
	

	
	
}

@Transactional
@Override
public List<Product> getProductList(String text) {
	Session session=sessionFactory.getCurrentSession();
	Criteria criteria=session.createCriteria(Product.class);
	criteria.add(Restrictions.like("title", "%"+text+"%"));
	Criterion criterionTitle=Restrictions.like("title", "%"+text+"%");
	Criterion criterionDescription=Restrictions.like("description", "%"+text+"%");
	LogicalExpression orExp=Restrictions.or(criterionTitle, criterionDescription);
	criteria.add(orExp);
	
	List<Product> list=criteria.list();
	for(Product p:list) {
		
		Hibernate.initialize(p.getStickers());}
	return list;
}

  /* @Transactional
   @Override
    public List<Product> getProductList(String text) {
	Session session=sessionFactory.getCurrentSession();
	
	String stringQuery="from Product p where p.title like :text or p.description like :text";
	Query query=session.createQuery(stringQuery);
	query.setParameter("text", "%"+text+"%");
	
	
	
	
	
	return query.getResultList();
}*/


}
