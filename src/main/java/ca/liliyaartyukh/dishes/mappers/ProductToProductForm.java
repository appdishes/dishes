package ca.liliyaartyukh.dishes.mappers;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ca.liliyaartyukh.dishes.domain.Dish;


@Component
public class ProductToProductForm implements Converter<Dish, DishForm> {
    @Override
    public DishForm convert(Dish product) {
        DishForm productForm = new DishForm();
        productForm.setId(product.getId());
        productForm.setDescription(product.getDescription());
        productForm.setName(product.getName());
        productForm.setCategory(product.getCategory());
        productForm.setType(product.getType());

        return productForm;
    }
}
