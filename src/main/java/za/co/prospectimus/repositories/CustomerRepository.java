package za.co.prospectimus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.prospectimus.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Customer findByCustomerId(Long customerId);

}
