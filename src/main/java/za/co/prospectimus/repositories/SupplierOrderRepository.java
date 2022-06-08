package za.co.prospectimus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.prospectimus.model.SupplierOrder;

public interface SupplierOrderRepository extends JpaRepository<SupplierOrder, Long> {

	public SupplierOrder findBySupplierOrderId(Long supplierOrder);

}
