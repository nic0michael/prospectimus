package za.co.prospectimus.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.prospectimus.model.CustomerOrder;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

	public List<CustomerOrder> findAllByCustomerId(Long customerId);

	public CustomerOrder findByCustomerOrderId(Long customerOrderId);

}
