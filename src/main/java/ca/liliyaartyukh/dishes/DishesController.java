package ca.liliyaartyukh.dishes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.liliyaartyukh.dishes.domain.Dish;
import ca.liliyaartyukh.dishes.services.DishService;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8090", "http://dishes.github.io/", "https://appdishes.herokuapp.com/"}, maxAge = 3600)
@RestController
public class DishesController {

	private DishService dishesService;

    @Autowired
    public void setDishService(DishService dishesService) {
        this.dishesService = dishesService;
    }
	
/*    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/dishes";
    }
    */
    
    @RequestMapping(method = RequestMethod.GET, value="/dishes" )
	public List<Dish> getAll() {
		return dishesService.listAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/dishes/category/{category}")
	public List<Dish> getByCategory(@PathVariable String category) {
		return dishesService.findByCategory(category);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/dishes/type/{type}")
	public List<Dish> getByType(@PathVariable String type) {
		return dishesService.findByType(type);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/dishes/{id}")
	public Dish getById(@PathVariable Integer id) {
		return dishesService.getById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/dishes")
	public Dish create(@RequestBody Dish dish) {
		return dishesService.saveOrUpdate(dish);
	}
	
	@RequestMapping(method = RequestMethod.PUT , value="/dishes")
	public Dish update(@RequestBody Dish input) {
		return dishesService.saveOrUpdate(input);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/dishes/{id}")
	public Iterable<Dish> delete(@PathVariable Integer id) {
		dishesService.deleteById(id);
		return dishesService.listAll();
	}
}
