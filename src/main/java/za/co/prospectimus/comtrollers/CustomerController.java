package za.co.prospectimus.comtrollers;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import za.co.prospectimus.dtos.CustomerOrderRequest;
import za.co.prospectimus.dtos.CustomerRequest;
import za.co.prospectimus.dtos.ProductRequest;
import za.co.prospectimus.logic.BusinessLogicProcessor;
import za.co.prospectimus.model.Customer;
import za.co.prospectimus.model.CustomerOrder;
import za.co.prospectimus.model.Employee;
import za.co.prospectimus.model.Product;
import za.co.prospectimus.model.Supplier;
import za.co.prospectimus.servicemanagers.EmployeeServiceManager;
import za.co.prospectimus.utils.RequestResponseUtils;

@Controller
@RequestMapping("/prospectus-dashboard/customers")
public class CustomerController {
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Value("${project.version}")
	private String projectVersion;
	
	@Value("${project.name}")
	private String projectName;
	


	@Autowired
	BusinessLogicProcessor processor;
	
	@GetMapping(value = "/list")
	public String listall(Model model) {
		List<Customer> customers = processor.findAllCustomersSortedByName();
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
		Customer customer =processor.saveCustomer(request);
		model.addAttribute("supplierRequest", request);


		List<Customer> customers = processor.findAllCustomersSortedByName();
		model.addAttribute("customerList", customers);
		return "customers/list-customers";
	}
	


	@PostMapping(value = "/update")
	public String updatesaveCustomer(CustomerRequest request,Model model) {
		log.info("SupplierController | saveCustomerOrder | request : "+request);
		if(request!=null) {
			Long customerId=request.getCustomerId();
			Customer customer =processor.findCustomerByCustomerId(customerId);
			customer =processor.updateCustomer(customer,request);		
		}

		List<Customer> customers = processor.findAllCustomersSortedByName();
		model.addAttribute("customerList", customers);
		return "customers/list-customers";
	}
	

	@GetMapping("/verander")
	public String verander(@RequestParam(value = "id") Long customerId,Model model) {
		log.info("ProductController | verander | customerId: "+customerId);

		
		Customer customer =processor.findCustomerByCustomerId(customerId);
		CustomerRequest request =  processor.makeCustomerRequest(customer);
		
		List<Supplier> suppliers = processor.findAllSuppliersSortedByName();
		model.addAttribute("customerRequest", request);
		model.addAttribute("supplierList", suppliers);

		return "customers/edit-customer";
	}
		




	
	@GetMapping("/maakdood")
	public String deleteCustomer(@RequestParam(value = "id") Long customerId,Model model) {
		log.info("BUSINESS : CustomerController : deleteCustomer : with customerId : "+customerId);
		processor.deleteCustomer(customerId);

		return listall(model) ;
		
	}
}
