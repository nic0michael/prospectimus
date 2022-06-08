package za.co.prospectimus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.prospectimus.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

	public Supplier findBySupplierId(Long productId);

}
