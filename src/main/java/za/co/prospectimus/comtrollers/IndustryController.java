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

import za.co.prospectimus.dtos.IndustryRequest;
import za.co.prospectimus.enums.ProjectDetails;
import za.co.prospectimus.dtos.IndustryRequest;
import za.co.prospectimus.helper.IndustryHelper;
import za.co.prospectimus.model.Industry;
import za.co.prospectimus.utils.RequestResponseUtils;

@Controller
@RequestMapping("/prospectus-dashboard/industries")
public class IndustryController {
	private static final Logger log = LoggerFactory.getLogger(IndustryController.class);

	private String projectVersion=ProjectDetails.DEFAULT.projectVersion();
	private String projectName=ProjectDetails.DEFAULT.projectName();
		

	@Autowired
	IndustryHelper helper;
	
	@GetMapping(value = "/list")
	public String listall(Model model) {
		List<Industry> industries = helper.findAllIndustriesSortedByName();
		model.addAttribute("industryList", industries);

		return "industries/list-industries";
		
	}
	

	@GetMapping(value = "/new")
	public String newProduct(Model model) {
		IndustryRequest request =  new IndustryRequest();
		Timestamp dateCreated =new Timestamp(new Date().getTime());
		request.setDateCreated(dateCreated);
		log.info("ProductController | newProduct | IndustryRequest : "+request);
		model.addAttribute("productRequest", request);

		return "industries/new-industry";
		
	}
	

	@PostMapping(value = "/save")
	public String saveProduct(IndustryRequest request,Model model) {
		log.info("SupplierController | saveProduct | request : "+request);
		if(request!=null) {
			Industry industry =helper.saveIndustry(request);	
		}

		List<Industry> industries = helper.findAllIndustriesSortedByName();
		model.addAttribute("productList", industries);
		return "industries/list-industries";
	}

	@PostMapping(value = "/update")
	public String supdateProduct(IndustryRequest request,Model model) {
		log.info("SupplierController | saveProduct | request : "+request);
		if(request!=null) {
			Long productId=0L;//request.getProductId();
			Industry industry=helper.findProductByProductId(productId);
			industry =helper.updateIndustry(industry,request);	
		}

		List<Industry> products = helper.findAllIndustriesSortedByName();
		model.addAttribute("productList", products);
		return "industries/list-industries";
	}
	

	@GetMapping("/verander")
	public String verander(@RequestParam(value = "id") Long productId,Model model) {
		Industry industry =helper.findProductByProductId(productId);
		 IndustryRequest request = RequestResponseUtils.makeIndustryRequest(industry);
		Timestamp dateCreated =new Timestamp(new Date().getTime());
		request.setDateCreated(dateCreated);
		model.addAttribute("industriesRequest", request);

		return "industries/edit-industry";
		
	}


	@GetMapping("/maakdood")
	public String deleteProduct(@RequestParam(value = "id") Long productId,Model model) {
		log.info("BUSINESS : ProductController : deleteProduct : with project_id : "+productId);
		helper.deleteIndustry(productId);

		return listall(model) ;
		
	}
}
