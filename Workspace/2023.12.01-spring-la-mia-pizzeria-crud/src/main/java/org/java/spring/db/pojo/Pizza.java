package org.java.spring.db.pojo;

import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Positive;

@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 32, nullable = false)
	@Length(min = 3, max = 32)
	private String name;
	
	@Column(columnDefinition = "TEXT")
	@Length(min = 3)
	private String description;
	
	@Column(columnDefinition = "TEXT")
	@URL
	private String photo;
	
	@Column(nullable = false)
	@Positive
	private int price;
	
	@OneToMany(mappedBy = "pizza")
	private List<Discount> discounts;
	
	public Pizza() { }
	public Pizza(String name, String description, String photo, int price) {
	
		setName(name);
		setDescription(description);
		setPhoto(photo);
		setPrice(price);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<Discount> getDiscounts() {
		return discounts;
	}
	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] " + getName() + " - " + getPrice() + "euro\n"
				+ getDescription() + "\n"
				+ getPhoto();
	}
}
