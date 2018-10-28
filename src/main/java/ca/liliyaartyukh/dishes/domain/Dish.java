package ca.liliyaartyukh.dishes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer _id;
	private String name;
	private String category;
	private String type;
	private String description;

	
	public Dish() {
		super();
	}

	public Dish(String name, String category, String type) {
		super();
		this.name = name;
		this.category = category;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public String getType() {
		return type;
	}

	
	
	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		this._id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Dish [id=" + _id + ", name=" + name + ", category=" + category + ", type=" + type + ", description="
				+ description + "]";
	}

}
