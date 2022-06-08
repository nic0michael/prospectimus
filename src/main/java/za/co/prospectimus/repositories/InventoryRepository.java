package za.co.prospectimus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.prospectimus.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	Inventory findByInventoryId(Long inventoryId);
	

}
