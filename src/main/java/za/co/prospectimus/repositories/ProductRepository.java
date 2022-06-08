package za.co.prospectimus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.prospectimus.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	public Product findByProductId(Long productId);

}
