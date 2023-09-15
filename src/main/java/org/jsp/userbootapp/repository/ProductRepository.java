package org.jsp.userbootapp.repository;

import org.jsp.userbootapp.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
