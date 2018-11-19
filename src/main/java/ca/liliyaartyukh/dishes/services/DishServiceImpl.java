package ca.liliyaartyukh.dishes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.liliyaartyukh.dishes.domain.Dish;
import ca.liliyaartyukh.dishes.exceptions.BackendException;
import ca.liliyaartyukh.dishes.mappers.ProductFormToProduct;
import ca.liliyaartyukh.dishes.repositories.DishesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {

    private DishesRepository dishesRepository;
    private ProductFormToProduct productFormToProduct;

    @Autowired
    public DishServiceImpl(DishesRepository dishesRepository, ProductFormToProduct productFormToProduct) {
        this.dishesRepository = dishesRepository;
        this.productFormToProduct = productFormToProduct;
    }


    @Override
    public List<Dish> listAll() {
        List<Dish> products = new ArrayList<Dish>();
        dishesRepository.findAll().forEach(products::add); //fun with Java 8
        return products;
    }

    @Override
    public List<Dish> getById(Integer id) {
    	List<Dish> dishesToReturn = null;
    	Optional<Dish> dishes = dishesRepository.findById(id);
    	if(dishes != null && dishes.isPresent()) {
    		dishesToReturn = new ArrayList<Dish>();
    		dishesToReturn.add(dishes.get());
    	}
        return dishesToReturn;
    }

    @Override
    public Dish saveNew(Dish dish) {
    	//TODO evaluate all possible scenarios and handle all errors
    	// 1. dish already exists - there should be no id in request. if id comes then earlier validation should throw exception
    	// 2. no connection to db
    	// 3. data is invalid - validation should happen before getting to this point
    	try {
    		dish.setId(null);
    		dishesRepository.save(dish);
    	}catch(Exception e) {
    		throw new BackendException("Invalid request!" + e);
    	}
        return dish;
    }
    
    @Override
    public Dish updateExisting(Dish dish) {
    	//TODO evaluate all possible scenarios and handle all errors
    	// 1. dish does not exist
    	// 2. no connection to db
    	// 3. data is invalid - validation should happen before getting to this point
    	try {
    		if(dish.getId() != null) {
    			dishesRepository.deleteById(dish.getId());
    		}
    		dishesRepository.save(dish);
    	}catch(Exception e) {
    		throw new BackendException("Invalid request!" + e);
    	}
        return dish;
    }

	@Override
	public List<Dish> findByType(String type) {
    	List<Dish> dishes = dishesRepository.findByType(type);
    	if(!(dishes != null && dishes.size() > 0)) {
    		return new ArrayList<Dish>();
    	}
        return dishes;
	}
	
	@Override
	public List<Dish> findByName(String name) {
    	List<Dish> dishes = dishesRepository.findByName(name);
    	if(!(dishes != null && dishes.size() > 0)) {
    		return new ArrayList<Dish>();
    	}
        return dishes;
	}

	@Override
	public List<Dish> findByCategory(String category) {
    	List<Dish> dishes = dishesRepository.findByCategory(category);
    	if(!(dishes != null && dishes.size() > 0)) {
    		return new ArrayList<Dish>();
    	}
        return dishes;
	}


	@Override
	public void deleteById(Integer id) {
		dishesRepository.deleteById(id);
		
	}

    /*
    @Override
    public Dish saveOrUpdateProductForm(ProductForm productForm) {
        Dish savedProduct = saveOrUpdate(productFormToProduct.convert(productForm));

        System.out.println("Saved Product Id: " + savedProduct.getId());
        return savedProduct;
    }
    */
}
