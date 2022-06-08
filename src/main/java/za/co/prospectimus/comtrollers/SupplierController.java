package za.co.prospectimus.comtrollers;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import za.co.prospectimus.dtos.CustomerOrderRequest;
import za.co.prospectimus.dtos.ProductRequest;
import za.co.prospectimus.dtos.SupplierRequest;
import za.co.prospectimus.logic.BusinessLogicProcessor;
import za.co.prospectimus.model.Employee;
import za.co.prospectimus.model.Product;
import za.co.prospectimus.model.Supplier;
import za.co.prospectimus.servicemanagers.EmployeeServiceManager;
import za.co.prospectimus.utils.RequestResponseUtils;

@Controller
@RequestMapping("/prospectus-dashboard/suppliers")
public class SupplierController {

	private static final Logger log = LoggerFactory.getLogger(SupplierController.class);
	
	@Value("${project.version}")
	private String projectVersion;
	
	@Value("${project.name}")
	private String projectName;
	

	@Autowired
	BusinessLogicProcessor processor;
	
	@GetMapping(value = "/list")
	public String listall(Model model) {
		List<Supplier> suppliers = processor.findAllSuppliersSortedByName();
		model.addAttribute("supplierList", suppliers);

		return "suppliers/list-suppliers";
		
	}

	@GetMapping(value = "/new")
	public String newCSupplier(Model model) {
		SupplierRequest request =new SupplierRequest();

		log.info("SupplierController | newCSupplier | SupplierRequest : "+request);
		Timestamp dateCreated =new Timestamp(new Date().getTime());
		request.setDateCreated(dateCreated);
		model.addAttribute("supplierRequest", request);

		return "suppliers/new-supplier";		
	}
	


	@PostMapping(value = "/save")
	public String saveSupplier(SupplierRequest request,Model model) {
		log.info("SupplierController | saveSupplier | request : "+request);
		Supplier supplier =processor.saveSupplier(request);
		model.addAttribute("supplierRequest", request);


		List<Supplier> suppliers = processor.findAllSuppliersSortedByName();
		model.addAttribute("supplierList", suppliers);
		return "suppliers/list-suppliers";	
	}


	@PostMapping(value = "/update")
	public String updateSupplier(SupplierRequest request,Model model) {
		log.info("SupplierController | saveSupplier | request : "+request);
		if(request!=null) {
			Long supplierId=request.getSupplierId();
			Supplier supplier =processor.findSupplierBySupplierId(supplierId);
			supplier =processor.updateSupplier(supplier,request);
		}
		model.addAttribute("supplierRequest", request);


		List<Supplier> suppliers = processor.findAllSuppliersSortedByName();
		model.addAttribute("supplierList", suppliers);
		return "suppliers/list-suppliers";	
	}

	@GetMapping("/verander")
	public String verander(@RequestParam(value = "id") Long supplierId,Model model) {
		Supplier supplier =processor.findSupplierBySupplierId( supplierId);
		SupplierRequest request =RequestResponseUtils.makeSupplierRequest(supplier);

		model.addAttribute("supplierRequest", request);
		return "suppliers/edit-supplier";
		
	}

	@GetMapping("/maakdood")
	public String deleteSupplier(@RequestParam(value = "id") Long suppliertId,Model model) {
		log.info("BUSINESS : ProductController : deleteProduct : with project_id : "+suppliertId);
		processor.deleteSupplier(suppliertId);

		return listall(model) ;
		
	}
}
