package cubes.main.dao;

import java.util.List;

import cubes.main.entity.Category;
import cubes.main.entity.Product;

public interface ProductDAO {
	public List<Product> getProductList();
	public void saveProduct(Product product);
	public Product getByProductId(int id);
	public Product deleteProduct(int id);
	public List<Product> getProductHomePage();
	public List<Product>getListProductBtCategoryId(int id);
	public List<Product> getProductList( Integer category,Integer price,Integer[]stickers);
    public List<Product> getProductList(String text);
}
