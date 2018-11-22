package ca.liliyaartyukh.dishes.services;

import java.util.List;

import ca.liliyaartyukh.dishes.domain.Dish;

public interface DishService {

    List<Dish> listAll();

    List<Dish> getById(Integer id);

    Dish updateExisting(Dish product);
    
    Dish saveNew(Dish product);

	List<Dish> findByType(String type);
	
	List<Dish> search(String searchWord);
	
	List<Dish> findByName(String name);

	List<Dish> findByCategory(String category);

	void deleteById(Integer id);

 //   Dish saveOrUpdateProductForm(ProductForm productForm);
}
