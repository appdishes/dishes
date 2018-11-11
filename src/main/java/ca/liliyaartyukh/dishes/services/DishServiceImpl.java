package ca.liliyaartyukh.dishes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.liliyaartyukh.dishes.domain.Dish;
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
    public Dish saveOrUpdate(Dish dish) {
    	if(dish.getId() != null) {
    		dishesRepository.deleteById(dish.getId());
    	}
    	dishesRepository.save(dish);
        return dish;
    }

	@Override
	public List<Dish> findByType(String type) {
		return dishesRepository.findByType(type);
	}


	@Override
	public List<Dish> findByCategory(String category) {
		return dishesRepository.findByCategory(category);
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
