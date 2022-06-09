package za.co.prospectimus.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import za.co.prospectimus.dtos.CustomerContactRequest;
import za.co.prospectimus.model.Customer;
import za.co.prospectimus.model.CustomerContact;
import za.co.prospectimus.model.Employee;
import za.co.prospectimus.repositories.ConfigurationRepository;
import za.co.prospectimus.repositories.CustomerContactRepository;
import za.co.prospectimus.repositories.CustomerRepository;
import za.co.prospectimus.repositories.EmployeeRepository;
import za.co.prospectimus.repositories.IndustryRepository;
import za.co.prospectimus.repositories.MarketSegmentRepository;
import za.co.prospectimus.utils.RequestResponseUtils;

@Component
public class CustomerContactHelper {


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
	


	public CustomerContact saveCustomerContact(CustomerContactRequest request) {
		// TODO Auto-generated method stub
		return null;
	}


	public CustomerContact findCustomerContactByCustomerContactId(Long customerOrderId) {
		// TODO Auto-generated method stub
		return null;
	}


	
	public List<CustomerContact> findAllCustomerContactSortedByName() {
		return custContactRep.findAll(sortByNameAsc());
	}	


	public List<CustomerContact> findAllByCustomer(Customer customer) {
		return custContactRep.findAllByCustomerId(customer.getCustomerId());
	}
	
	public CustomerContact findCustomerOrderByCustomerOrderId(Long customerContactId) {
		CustomerContact customerContact= custContactRep.findByCustomerContactId(customerContactId);
		return customerContact;
	}

	public void deleteCustomerContact(Long customerContactId) {
		custContactRep.deleteById(customerContactId);		
	}
	

	public CustomerContact saveCustomerContact(CustomerContact customerCont) {
		customerCont=custContactRep.save(customerCont);
		return customerCont;
	}



	public CustomerContact updateCustomerContact(CustomerContact customerContact, CustomerContactRequest request) {
		if(request!=null && request.getEmployeeId() !=null) {
			Long employeeId = request.getEmployeeId();
			Employee employee =employeeRep.findByEmployeeId(employeeId);
			if(employee!=null) {
				request.setEmployeeFullname(employee.getFullName());
			}
		}
		customerContact=RequestResponseUtils.updateCustomerOrder(customerContact,request);
		customerContact=saveCustomerContact(customerContact);
		return customerContact;
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
