package za.co.prospectimus.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.prospectimus.dtos.ConfigurationRequest;
import za.co.prospectimus.model.Configuration;
import za.co.prospectimus.repositories.ConfigurationRepository;
import za.co.prospectimus.utils.RequestResponseUtils;

@Component
public class ConfigurationHelper {

	private String companyName = null;
	private String branchName  = null;
	private String branchPhone = null;
	
	@Autowired
	ConfigurationRepository confRep;
	


	public Configuration saveConfiguration(ConfigurationRequest request) {
		Configuration configuration=RequestResponseUtils.makeConfiguration(request);	
		
		return confRep.save(configuration);
	}

	public List<Configuration> findAllConfigurations() {
		List<Configuration> configurations=confRep.findAll();
		return configurations;
	}
	


	public Configuration findConfigurationByConfigurationId(Long configurationId) {
		Configuration configuration =confRep.findByConfigurationId(configurationId);
		return configuration;
	}
	

	public Configuration getConfiguration() {
		Configuration configuration = null;
		List<Configuration>  configurations = findAllConfigurations();
		for (Configuration configuration2 : configurations) {
			if(null != configuration2) {
				configuration =configuration2;
			}
		}
		
		return configuration;
	}

	public Configuration updateConfiguration(Configuration configuration, ConfigurationRequest request) {
		configuration=RequestResponseUtils.updateConfiguration(configuration, request);
		confRep.save(configuration);
		return configuration;
	}
	

	public void deleteConfiguration(Long configurationtId) {
		Configuration configuration =confRep.findByConfigurationId(configurationtId);
		confRep.delete(configuration);
	}
	

	public String getCompanyName() {
		if(null==companyName) {
			setConfigurationVariables();
		}
		return companyName;
	}

	public String getBranchName() {
		if(null==branchName) {
			setConfigurationVariables();
		}
		return branchName;
	}

	public String getBranchPhone() {
		if(null==branchPhone) {
			setConfigurationVariables();
		}
		return branchPhone;
	}
	
	private void setConfigurationVariables() {
		
		List<Configuration> configurations =confRep.findAll();
		Configuration configuration=null;
		for (Configuration theConfiguration : configurations) {
			if(null!= theConfiguration) {
				configuration=theConfiguration;
				break;
			}
		}
		if(null!= configuration) {
			companyName = configuration.getCompanyName();
			branchName  = configuration.getBranchName();
			branchPhone  = configuration.getBranchPhone();
		}
	}
	
	
}
