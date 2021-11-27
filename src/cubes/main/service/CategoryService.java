package cubes.main.service;

import java.util.List;

import cubes.main.entity.Category;

public interface CategoryService {
	
	public List<Category> getCategoryList();
	public void saveCategory(Category category);
	public Category getByCategoryId(Integer id);
	public Category deleteCategory(int id);
	public List<Category> getCategoryHomepageList();
	public int getCount(int id);
}
