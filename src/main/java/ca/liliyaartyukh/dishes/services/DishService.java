package ca.liliyaartyukh.dishes.services;

import java.util.List;

import ca.liliyaartyukh.dishes.domain.Dish;

public interface DishService {

    List<Dish> listAll();

    Dish getById(Integer id);

    Dish saveOrUpdate(Dish product);

	List<Dish> findByType(String type);

	List<Dish> findByCategory(String category);

	void deleteById(Integer id);

 //   Dish saveOrUpdateProductForm(ProductForm productForm);
}