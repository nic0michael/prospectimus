package za.co.prospectimus.helper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import za.co.prospectimus.dtos.MarketSegmentRequest;
import za.co.prospectimus.model.MarketSegment;
import za.co.prospectimus.repositories.ConfigurationRepository;
import za.co.prospectimus.repositories.CustomerContactRepository;
import za.co.prospectimus.repositories.CustomerRepository;
import za.co.prospectimus.repositories.EmployeeRepository;
import za.co.prospectimus.repositories.IndustryRepository;
import za.co.prospectimus.repositories.MarketSegmentRepository;
import za.co.prospectimus.utils.RequestResponseUtils;

@Component
public class MarketSegmentHelper {	
	private static final Logger log = LoggerFactory.getLogger(MarketSegmentHelper.class);

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
	

	public void addGraduity(MarketSegmentRequest request) {
		MarketSegment marketSegment = RequestResponseUtils.makeMarketSegment(request);
		if(null!=marketSegment) {
			marketSegRepository.save(marketSegment);
		}
	}

	public List<MarketSegment> findAllGraduities() {
		List<MarketSegment> gratuities = marketSegRepository.findAll(sortByDateCreatedDesc());
		if(gratuities!=null) {
			log.info("gratuities has "+gratuities.size()+" records");
		} else {
			log.info("gratuities is null ");			
		}
		return gratuities;
	}

	public void deleteGratuity(Long marketSegmentId) {
		MarketSegment gratuity = marketSegRepository.findByMarketSegmentId(marketSegmentId);
		marketSegRepository.delete(gratuity);
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
