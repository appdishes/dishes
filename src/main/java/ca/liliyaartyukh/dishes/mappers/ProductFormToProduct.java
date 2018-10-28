package ca.liliyaartyukh.dishes.mappers;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ca.liliyaartyukh.dishes.domain.Dish;


@Component
public class ProductFormToProduct implements Converter<DishForm, Dish> {

    @Override
    public Dish convert(DishForm dishForm) {
        Dish dish = new Dish();
        if (dishForm.getId() != null) {
        	dish.setId(dishForm.getId());
        }
        if (dishForm.getDescription() != null  && !StringUtils.isEmpty(dishForm.getDescription())) {
            dish.setDescription(dishForm.getDescription());
        }
        if (dishForm.getName() != null  && !StringUtils.isEmpty(dishForm.getName())) {
            dish.setName(dishForm.getName());
        }
        if (dishForm.getType() != null  && !StringUtils.isEmpty(dishForm.getType())) {
            dish.setType(dishForm.getType());
        }
        if (dishForm.getCategory() != null  && !StringUtils.isEmpty(dishForm.getCategory())) {
            dish.setCategory(dishForm.getCategory());
        }
        return dish;
    }
}
