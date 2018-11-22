package ca.liliyaartyukh.dishes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.liliyaartyukh.dishes.domain.Dish;
import ca.liliyaartyukh.dishes.exceptions.BackendException;
import ca.liliyaartyukh.dishes.services.DishService;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8090", "https://appdishes.github.io", "https://appdishes.herokuapp.com/"}, maxAge = 3600)
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
	
	@RequestMapping(method = RequestMethod.GET, value = "/dishes/by")
	public List<Dish> getBy(@RequestParam Map<String, String> customQuery) {
		String name = null;
		String type = null;
		String category = null;
		
		if(customQuery.containsKey("name") ) {
			name = customQuery.get("name");
		}else if(customQuery.containsKey("type") ) {
			type = customQuery.get("type");
		} else if(customQuery.containsKey("category") ) {
			category = customQuery.get("category");
		}
		
		if( name != null && !name.isEmpty()) {
			return dishesService.findByName(name);
		}else if( type != null && !type.isEmpty()) {
			return dishesService.findByType(type);
		}else if( category != null && !category.isEmpty()) {
			return dishesService.findByCategory(category);
		}else {
			throw new BackendException("Invalid request!");
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/dishes/search")
	public List<Dish> find(@RequestParam("search") String searchWord) {
		
		if( searchWord != null && !searchWord.isEmpty()) {
			return dishesService.search(searchWord);
		}else {
			throw new BackendException("Invalid request!");
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/dishes/{id}")
	public List<Dish> getById(@PathVariable Integer id) {
		return dishesService.getById(id);
	}
	@RequestMapping(method = RequestMethod.POST, value="/dishes")
	public Dish create(@RequestBody Dish dish) {
		return dishesService.saveNew(dish);
	}
	
	@RequestMapping(method = RequestMethod.PUT , value="/dishes")
	public Dish update(@RequestBody Dish input) {
		return dishesService.updateExisting(input);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/dishes/{id}")
	public Iterable<Dish> delete(@PathVariable Integer id) {
		dishesService.deleteById(id);
		return dishesService.listAll();
	}
}
