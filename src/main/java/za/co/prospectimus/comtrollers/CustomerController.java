package za.co.prospectimus.comtrollers;

import java.sql.Timestamp;
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

import za.co.prospectimus.dtos.CustomerRequest;
import za.co.prospectimus.helper.CustomerContactHelper;
import za.co.prospectimus.helper.CustomerHelper;
import za.co.prospectimus.helper.IndustryHelper;
import za.co.prospectimus.helper.MarketSegmentHelper;
import za.co.prospectimus.model.Customer;
import za.co.prospectimus.servicemanagers.EmployeeServiceManager;

@Controller
@RequestMapping("/prospectus-dashboard/customers")
public class CustomerController {
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Value("${project.version}")
	private String projectVersion;
	
	@Value("${project.name}")
	private String projectName;
	

	@Autowired
	CustomerHelper customerHelper;
	
	@Autowired
	CustomerContactHelper customerContactHelper;

	@Autowired
	EmployeeServiceManager emplmod;

	@Autowired
	IndustryHelper industryHelper;
	
	@Autowired
	MarketSegmentHelper marketHelper;
	
	@GetMapping(value = "/list")
	public String listall(Model model) {
		List<Customer> customers = customerHelper.findAllCustomersSortedByName();
		model.addAttribute("customerList", customers);
		return "customers/list-customers";
		
	}
	
	@GetMapping(value = "/new")
	public String newCustomer(Model model) {
		CustomerRequest request =new CustomerRequest();
		Timestamp dateCreated =new Timestamp(new Date().getTime());
		request.setDateCreated(dateCreated);
		model.addAttribute("customerRequest", request);

		return "customers/new-customer";
		
	}

	@PostMapping(value = "/save")
	public String saveCustomer(CustomerRequest request,Model model) {
		log.info("SupplierController | saveCustomerOrder | request : "+request);
		Customer customer =customerHelper.saveCustomer(request);
		model.addAttribute("supplierRequest", request);


		List<Customer> customers = customerHelper.findAllCustomersSortedByName();
		model.addAttribute("customerList", customers);
		return "customers/list-customers";
	}

	@PostMapping(value = "/update")
	public String updatesaveCustomer(CustomerRequest request,Model model) {
		log.info("SupplierController | saveCustomerOrder | request : "+request);
		if(request!=null) {
			Long customerId=request.getCustomerId();
			Customer customer =customerHelper.findCustomerByCustomerId(customerId);
			customer =customerHelper.updateCustomer(customer,request);		
		}

		List<Customer> customers = customerHelper.findAllCustomersSortedByName();
		model.addAttribute("customerList", customers);
		return "customers/list-customers";
	}
	

	@GetMapping("/verander")
	public String verander(@RequestParam(value = "id") Long customerId,Model model) {
		log.info("ProductController | verander | customerId: "+customerId);

		
		Customer customer =customerHelper.findCustomerByCustomerId(customerId);
		CustomerRequest request =  customerHelper.makeCustomerRequest(customer);
		model.addAttribute("customerRequest", request);

		return "customers/edit-customer";
	}
		
	
	@GetMapping("/maakdood")
	public String deleteCustomer(@RequestParam(value = "id") Long customerId,Model model) {
		log.info("BUSINESS : CustomerController : deleteCustomer : with customerId : "+customerId);
		customerHelper.deleteCustomer(customerId);

		return listall(model) ;
		
	}
}
