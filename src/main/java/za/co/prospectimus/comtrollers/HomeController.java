package za.co.prospectimus.comtrollers;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import za.co.prospectimus.enums.ProjectDetails;
import za.co.prospectimus.helper.ConfigurationHelper;
import za.co.prospectimus.servicemanagers.EmployeeServiceManager;



@Controller
public class HomeController {
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	private String projectVersion=ProjectDetails.DEFAULT.projectVersion();
	private String projectName=ProjectDetails.DEFAULT.projectName();

	@Autowired
	private EmployeeServiceManager emplmod;
	
	@Autowired
	ConfigurationHelper processor;

	@GetMapping("prospectus-dashboard") //prospectus-dashboard
	public String displayHome1(Model model) {
		return "redirect:/prospectus-dashboard/home";
	}
	
	@GetMapping("/home")
	public String displayHome2(Model model) {
		return "redirect:/prospectus-dashboard/home";
	}
	
//	@GetMapping DO NOT ADD THIS CODE
//	public String displayHome(Model model) {
//		return "redirect:/prospectus-dashboard/home";
//	}

	@GetMapping("/prospectus-dashboard/home")
	public String displayHomePage(Model model) {	
		Path currentPath = Paths.get(".");
		Path absolutePath = currentPath.toAbsolutePath();
		Path imagePath = Paths.get(absolutePath + "/src/main/resources/static/images/ShopFront.jpg");
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String simpleDate = simpleDateFormat.format(new Date());
		
		String companyName = processor.getCompanyName();
		String branchName  = processor.getBranchName();
		String branchPhone = processor.getBranchPhone();
		

		model.addAttribute("companyName", companyName);
		model.addAttribute("branchName", branchName);
		model.addAttribute("branchPhone", branchPhone);
		
		
		model.addAttribute("simpleDate", simpleDate);
		model.addAttribute("timestamp", Instant.now());		
		model.addAttribute("projectVersion", projectVersion);
		model.addAttribute("projectName", projectName);
		model.addAttribute("imagePath", imagePath);

		return "main/home";
	}
	


}
