package ca.liliyaartyukh.dishes.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import ca.liliyaartyukh.dishes.domain.Dish;

@Component
public interface DishesRepository extends CrudRepository<Dish, Integer> {

    public List<Dish> findByCategory(String category);
    public List<Dish> findByType(String type);

}