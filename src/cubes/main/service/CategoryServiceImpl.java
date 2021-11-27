package cubes.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cubes.main.dao.CategoryDAO;
import cubes.main.entity.Category;
@Service
public class CategoryServiceImpl implements CategoryService {
 @Autowired
	private CategoryDAO categoryDAO;
@Transactional
 @Override
	public List<Category> getCategoryList() {
		//Ovde ide kod koji ne treba da bude u kon i dao
		return categoryDAO.getCategoryList();
	}
@Transactional
	@Override
	public void saveCategory(Category category) {
		categoryDAO.saveCategory(category);
		
	}
@Transactional
	@Override
	public Category getByCategoryId(Integer id) {
		// TODO Auto-generated method stub
		return categoryDAO.getByCategoryId(id);
	}
@Transactional
	@Override
	public Category deleteCategory(int id) {
		// TODO Auto-generated method stub
		return categoryDAO.deleteCategory(id);
	}
@Transactional
@Override
public List<Category> getCategoryHomepageList() {
	// TODO Auto-generated method stub
	return categoryDAO.getCategoryHomepageList();
}
@Transactional
@Override
public int getCount(int id) {
	// TODO Auto-generated method stub
	return categoryDAO.getCount(id);
}

}
