package za.co.prospectimus.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.co.prospectimus.dtos.ConfigurationRequest;
import za.co.prospectimus.dtos.CustomerContactRequest;
import za.co.prospectimus.dtos.CustomerRequest;
import za.co.prospectimus.dtos.IndustryRequest;
import za.co.prospectimus.dtos.MarketSegmentRequest;
import za.co.prospectimus.model.Configuration;
import za.co.prospectimus.model.Customer;
import za.co.prospectimus.model.CustomerContact;
import za.co.prospectimus.model.Industry;
import za.co.prospectimus.model.MarketSegment;

public class RequestResponseUtils {
	private static final Logger log = LoggerFactory.getLogger(RequestResponseUtils.class);

	public static Configuration makeConfiguration(ConfigurationRequest request) {
		Configuration configuration = new Configuration();
		return updateConfiguration(configuration, request);
	}

	public static Configuration updateConfiguration(Configuration configuration, ConfigurationRequest request) {
		if (configuration != null && request != null) {
			configuration.setDateCreated(request.getDateCreated());
			configuration.setCompanyName(request.getCompanyName());
			configuration.setBranchName(request.getBranchName());
			configuration.setBranchPhone(request.getBranchPhone());
			configuration.setIndustry(request.getIndustry());
			configuration.setEmail(request.getEmail());
			configuration.setEnabled(request.getEnabled());
			configuration.setDiscount(request.getDiscount());

		}
		return configuration;
	}

	public static ConfigurationRequest makeConfigurationRequest(Configuration configuration) {
		ConfigurationRequest request = new ConfigurationRequest();
		if (configuration != null) {
			request.setDateCreated(configuration.getDateCreated());
			request.setCompanyName(configuration.getCompanyName());
			request.setBranchName(configuration.getBranchName());
			request.setBranchPhone(configuration.getBranchPhone());
			request.setIndustry(configuration.getIndustry());
			request.setEmail(configuration.getEmail());
			request.setEnabled(configuration.getEnabled());
			request.setConfigurationId(configuration.getConfigurationId());
			request.setDiscount(configuration.getDiscount());

		}
		return request;
	}




	public static Industry makeRequestResponseUtils(IndustryRequest request) {
		Industry product = new Industry();
		return makeUpdateRequestResponseUtils(product, request);
	}

	public static Industry makeUpdateRequestResponseUtils(Industry product, IndustryRequest request) {
		if (request != null) {
			product.setDateCreated(request.getDateCreated());
			product.setDescription(request.getDescription());
			product.setName(request.getName());
		}

		return product;
	}



	public static IndustryRequest makeIndustryRequest(Industry industry) {
		// TODO Auto-generated method stub
		return null;
	}


	public static CustomerContactRequest makeCustomerContactRequest(CustomerContact customerOrder) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static CustomerContact makeCustomerOrder(CustomerContactRequest request) {
		CustomerContact customerOrder = new CustomerContact();
		return updateCustomerOrder(customerOrder, request);
	}

	public static CustomerContact updateCustomerOrder(CustomerContact customerOrder, CustomerContactRequest request) {

		if (request != null) {
			customerOrder.setCustomerId(request.getCustomerId());
			customerOrder.setCustomerName(request.getCustomerName());
			customerOrder.setDateCreated(request.getDateCreated());
		}

		return customerOrder;
	}

	public static CustomerContactRequest makeCustomerOrderRequest(CustomerContact customerOrder) {
		CustomerContactRequest request = new CustomerContactRequest();
		if (customerOrder != null) {
			request.setCustomerId(customerOrder.getCustomerId());
			request.setCustomerName(customerOrder.getCustomerName());
			request.setDateCreated(customerOrder.getDateCreated());
		}
		return request;
	}

	public static Customer makeCustomer(CustomerRequest request) {
		Customer customer = new Customer();
		return updateCustomer(customer, request);
	}

	public static Customer updateCustomer(Customer customer, CustomerRequest request) {
		if (request != null && customer != null) {
			customer.setCellPhone(request.getCellPhone());
			customer.setDateCreated(request.getDateCreated());
			customer.setDeliveryAddress(request.getDeliveryAddress());
			customer.setEmailAddress(request.getEmailAddress());
			customer.setInvoiceAddress(request.getInvoiceAddress());
			customer.setName(request.getName());
		}
		return customer;
	}

	public static CustomerRequest makeCustomerRequest(Customer customer) {
		CustomerRequest request = new CustomerRequest();
		if (customer != null) {
			request.setCustomerId(customer.getCustomerId());
			request.setCellPhone(customer.getCellPhone());
			request.setDateCreated(customer.getDateCreated());
			request.setDeliveryAddress(customer.getDeliveryAddress());
			request.setEmailAddress(customer.getEmailAddress());
			request.setInvoiceAddress(customer.getInvoiceAddress());
			request.setName(customer.getName());

		}
		return request;
	}

	public static MarketSegment makeMarketSegment(MarketSegmentRequest request) {
		MarketSegment marketSegment = new MarketSegment();

		log.info("---> request " + request);
//
//		marketSegment.setCustomerId(request.getCustomerId());
//		marketSegment.setCustomerName(request.getCustomerName());

		return marketSegment;
	}





}
