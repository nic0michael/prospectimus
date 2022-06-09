package za.co.prospectimus.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.prospectimus.model.CustomerContact;

public interface CustomerContactRepository extends JpaRepository<CustomerContact, Long> {

	public List<CustomerContact> findAllByCustomerId(Long customerId);

	public CustomerContact findByCustomerContactId(Long customerContactId);

}
