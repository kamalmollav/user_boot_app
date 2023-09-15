package org.jsp.userbootapp.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@Column(nullable=false,unique=true)
private String name;
@Column(nullable=false)
private String branch;
@Column(nullable=false)
private float price;
@Column(nullable=false)
private String image;
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
public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}

}
