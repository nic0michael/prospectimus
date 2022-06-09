package za.co.prospectimus.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import za.co.prospectimus.dtos.CustomerRequest;
import za.co.prospectimus.model.Customer;
import za.co.prospectimus.repositories.ConfigurationRepository;
import za.co.prospectimus.repositories.CustomerContactRepository;
import za.co.prospectimus.repositories.CustomerRepository;
import za.co.prospectimus.repositories.EmployeeRepository;
import za.co.prospectimus.repositories.IndustryRepository;
import za.co.prospectimus.repositories.MarketSegmentRepository;
import za.co.prospectimus.utils.RequestResponseUtils;

@Component
public class CustomerHelper {


	@Autowired
	CustomerRepository custRep;
	
	@Autowired
	CustomerContactRepository custContactRep;
	
	@Autowired
	IndustryRepository industryRep;
	
	@Autowired
	EmployeeRepository employeeRep;
	
	@Autowired
	ConfigurationRepository confRep;
	
	@Autowired
	MarketSegmentRepository marketSegRepository;

	public List<Customer> findAllCustomersSortedByName() {
		return custRep.findAll(sortByNameAsc());
	}

	public Customer findCustomerByCustomerId(Long customerId) {
		return custRep.findByCustomerId(customerId);
	}

	public void deleteCustomer(Long customerId) {	
		custRep.deleteById(customerId);
	}

	public Customer saveCustomer(CustomerRequest request) {
		Customer customer=RequestResponseUtils.makeCustomer(request);
		customer=custRep.save(customer);
		return customer;
	}

	public Customer updateCustomer(Customer customer,CustomerRequest request) {
		customer=RequestResponseUtils.updateCustomer(customer,request);
		customer=custRep.save(customer);
		return customer;
	}


	public CustomerRequest makeCustomerRequest(Customer customer) {
		CustomerRequest request=RequestResponseUtils.makeCustomerRequest(customer);
		return request;
	}



	
	private Sort sortByDateCreatedAsc() {
        return new Sort(Sort.Direction.ASC, "dateCreated");
    }
	
	private Sort sortByDateCreatedDesc() {
        return new Sort(Sort.Direction.DESC, "dateCreated");
    }

	private Sort sortByNameAsc() {
        return new Sort(Sort.Direction.ASC, "name");
    }

}
