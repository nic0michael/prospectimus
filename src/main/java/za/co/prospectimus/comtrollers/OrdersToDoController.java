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
import za.co.prospectimus.dtos.ProductRequest;
import za.co.prospectimus.dtos.SupplierRequest;
import za.co.prospectimus.logic.BusinessLogicProcessor;
import za.co.prospectimus.model.Customer;
import za.co.prospectimus.model.CustomerOrder;
import za.co.prospectimus.model.Employee;
import za.co.prospectimus.model.Product;
import za.co.prospectimus.model.Supplier;
import za.co.prospectimus.servicemanagers.EmployeeServiceManager;
import za.co.prospectimus.utils.RequestResponseUtils;
import za.co.prospectimus.utils.Utils;

@Controller
@RequestMapping("/prospectus-dashboard/orders-to-do")
public class OrdersToDoController {

	private static final Logger log = LoggerFactory.getLogger(OrdersToDoController.class);
	
	@Value("${project.version}")
	private String projectVersion;
	
	@Value("${project.name}")
	private String projectName;

	@Autowired
	BusinessLogicProcessor processor;
	
	@GetMapping(value = "/list")
	public String listall(Model model) {
		List<CustomerOrder> customerOrders = processor.findAllCustomerOrdersSortedByDate();
		model.addAttribute("customerOrderList", customerOrders);
		return "customers/list-orders-to-do";		
	}
	

	
	@GetMapping("/completed")
	public String completedOrder(@RequestParam(value = "id") Long customerOrderId,Model model) {
		CustomerOrder customerOrder=processor.findCustomerOrderByCustomerOrderId(customerOrderId);
		customerOrder.setOrderCompleted(true);
		processor.saveCustomerOrder(customerOrder);		

		List<CustomerOrder> customerOrders = processor.findAllCustomerOrdersSortedByDate();
		model.addAttribute("customerOrderList", customerOrders);
		return "customers/list-orders-to-do";
	}

}
