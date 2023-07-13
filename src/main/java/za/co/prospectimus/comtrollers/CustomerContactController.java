package za.co.prospectimus.comtrollers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import za.co.prospectimus.dtos.CustomerContactRequest;
import za.co.prospectimus.enums.ProjectDetails;
import za.co.prospectimus.helper.CustomerContactHelper;
import za.co.prospectimus.helper.CustomerHelper;
import za.co.prospectimus.helper.EmployeeHelper;
import za.co.prospectimus.model.Customer;
import za.co.prospectimus.model.CustomerContact;
import za.co.prospectimus.model.Employee;
import za.co.prospectimus.model.Industry;
import za.co.prospectimus.utils.RequestResponseUtils;

@Controller
@RequestMapping("/prospectus-dashboard/customer-contacts")
public class CustomerContactController {

	private static final Logger log = LoggerFactory.getLogger(CustomerContactController.class);

	private String projectVersion=ProjectDetails.DEFAULT.projectVersion();
	private String projectName=ProjectDetails.DEFAULT.projectName();
	
	private final double DISCOUNT_PERCENTAGE=10;
	@Autowired
	CustomerHelper customerHelper;
	
	@Autowired
	CustomerContactHelper customerContactHelper;

	@Autowired
	EmployeeHelper emplHelper;
	


	@GetMapping(value = "/list")
	public String listall(Model model) {

		List<CustomerContact> customerContacts = customerContactHelper.findAllCustomerContactSortedByName();
		model.addAttribute("customerContactList", customerContacts);
		return "customer-contacts/list-customer-contacts";
		
	}


	@GetMapping(value = "/new")
	public String newCustomerContact(Model model) {
		CustomerContactRequest request = new CustomerContactRequest();
		Timestamp dateCreated = new Timestamp(new Date().getTime());
		request.setDateCreated(dateCreated);
		List<Employee> employees = emplHelper.findAllActiveEmployees();
		List<Customer> customers = customerHelper.findAllCustomersSortedByName();
		model.addAttribute("customerOrderRequest", request);
		model.addAttribute("employeeList", employees);
		model.addAttribute("customerList", customers);

		return "customer-contacts/new-customer-contacts";

	}

	@PostMapping(value = "/save")
	public String saveCustomerContact(CustomerContactRequest request, Model model) {
		log.info("CustomerContactController | saveCustomerContact | request : " + request);
		if (request != null) {


			Long customerId = request.getCustomerId();
			Customer customer = customerHelper.findCustomerByCustomerId(customerId);
			if (customer != null) {
				request.setCustomerName(customer.getName());
			}
		}
		CustomerContact customerContact = customerContactHelper.saveCustomerContact(request);
		model.addAttribute("supplierRequest", request);

		List<CustomerContact> customerContacts = customerContactHelper.findAllCustomerContactSortedByName();
		model.addAttribute("customerOrderList", customerContacts);
		return "customer-contacts/list-customer-contacts";
	}

	@PostMapping(value = "/update")
	public String updateCustomerContact(CustomerContactRequest request, Model model) {
		log.info("CustomerContactController | saveCustomerContact | request : " + request);
		if (request != null) {


			Long customerId = request.getCustomerId();
			Customer customer = customerHelper.findCustomerByCustomerId(customerId);
			if (customer != null) {
				request.setCustomerName(customer.getName());
			}

			Long customerOrderId = 0L;//request.getCustomerContactId();
			CustomerContact customerContact = customerContactHelper.findCustomerContactByCustomerContactId(customerOrderId);
			if (customerContact != null) {
				customerContact = customerContactHelper.updateCustomerContact(customerContact, request);
			}
		}
		model.addAttribute("supplierRequest", request);

		List<CustomerContact> customerContacts = customerContactHelper.findAllCustomerContactSortedByName();
		model.addAttribute("customerContactList", customerContacts);
		return "customer-contacts/list-customer-contacts";
	}

	@GetMapping("/addorder")
	public String addOrdernder(@RequestParam(value = "id") Long customerId, Model model) {
		List<Employee> employees = emplHelper.findAllActiveEmployees();
		Customer customer = customerHelper.findCustomerByCustomerId(customerId);
		List<Customer> customers = new ArrayList<>();
		customers.add(customer);

		CustomerContactRequest request = new CustomerContactRequest();
		Timestamp dateCreated = new Timestamp(new Date().getTime());
		request.setDateCreated(dateCreated);


		model.addAttribute("customerOrderRequest", request);
		model.addAttribute("customerList", customers);
		model.addAttribute("employeeList", employees);

		return "customer-contacts/new-customer-contact";

	}

	@GetMapping("/printinvoice")
	public String printinvoice(@RequestParam(value = "id") Long customerId, Model model) {

		
		List<Customer> customers = customerHelper.findAllCustomersSortedByName();
		model.addAttribute("customerList", customers);
		return "customer-contacts/list-customer-contacts";
	}



	@GetMapping("/verander")
	public String verander(@RequestParam(value = "id") Long customerOrderId, Model model) {
		log.info(
				"BUSINESS : CustomerContactController : deleteCustomerContact : with customerOrderId : " + customerOrderId);
		CustomerContact customerContact = customerContactHelper.findCustomerContactByCustomerContactId(customerOrderId);
		List<Employee> employees = emplHelper.findAllActiveEmployees();

		CustomerContactRequest request = RequestResponseUtils.makeCustomerContactRequest(customerContact);


		List<Customer> customers = customerHelper.findAllCustomersSortedByName();
		model.addAttribute("customerOrderRequest", request);
		model.addAttribute("customerList", customers);
		model.addAttribute("employeeList", employees);

		return "customer-contacts/edit-customer-contact";

	}

	@GetMapping("/maakdood")
	public String deleteCustomerContact(@RequestParam(value = "id") Long customerOrderId, Model model) {
		log.info("BUSINESS : CustomerContactController : deleteCustomerContact : with customerOrderId : " + customerOrderId);
		customerContactHelper.deleteCustomerContact(customerOrderId);

		return listall(model);

	}


}
