package za.co.prospectimus.helper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import za.co.prospectimus.dtos.IndustryRequest;
import za.co.prospectimus.model.Industry;
import za.co.prospectimus.repositories.IndustryRepository;
import za.co.prospectimus.utils.RequestResponseUtils;

@Component
public class IndustryHelper {
	private static final Logger log = LoggerFactory.getLogger(IndustryHelper.class);


	@Autowired
	IndustryRepository industryRep;
	


	public List<Industry> findAllIndustriesSortedByName() {
		return industryRep.findAll(sortByNameAsc());
	}
	
	public Industry findProductByProductId(Long productId){
		Industry industry=industryRep.findByIndustryId(productId);
		return industry;
	}


	public void deleteIndustry(Long industryId) {
		if(industryId!=null) {
			log.info("Deleting Ptoduct | productId : "+industryId );
			Industry industry=industryRep.findByIndustryId(industryId);
			if(industry!=null) {			
				industryRep.deleteById(industryId);
				log.info("Deleted Ptoduct | productId : "+industryId );
			}
		}
	}	

	public Industry saveIndustry(IndustryRequest request) {
		Industry product=RequestResponseUtils.makeRequestResponseUtils(request);
		return industryRep.save(product);
	}


	public Industry updateIndustry(Industry industry,IndustryRequest request) {
		if(request!=null) {
			industry=RequestResponseUtils.makeUpdateRequestResponseUtils(industry,request);
			industry=industryRep.save(industry);
		}
		
		return industry;
	}

	public IndustryRequest makeIndustryRequest(Industry industry) {
		IndustryRequest request=RequestResponseUtils.makeIndustryRequest(industry);
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
