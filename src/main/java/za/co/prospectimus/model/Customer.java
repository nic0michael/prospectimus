package za.co.prospectimus.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long customerId;	

	@Column(name = "idustry_id")
	private Long industryId;
	
	@Column(name = "market_segment_id")
	private Long marketSegmentId;

	@Column(name = "date_created")
	private Timestamp dateCreated;

	@Column(name = "name", length=256)
	private String name; 
	
	@Column(name = "delivery_address", length=256)
	private String deliveryAddress;
	
	@Column(name = "invoice_address", length=256)
	private String invoiceAddress;
	
	@Column(name = "email_address", length=128)
	private String emailAddress;
	
	@Column(name = "cell_phone", length=128)
	private String cellPhone;
	
	@Column(name = "industry", length=256)
	private String industry;
	
	@Column(name = "market_segment", length=256)
	private String marketSegment;

	@Column(name = "region", length=2048)
	private String region;

	public Long getIndustryId() {
		return industryId;
	}

	public void setIndustryId(Long industryId) {
		this.industryId = industryId;
	}

	public Long getMarketSegmentId() {
		return marketSegmentId;
	}

	public void setMarketSegmentId(Long marketSegmentId) {
		this.marketSegmentId = marketSegmentId;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getInvoiceAddress() {
		return invoiceAddress;
	}

	public void setInvoiceAddress(String invoiceAddress) {
		this.invoiceAddress = invoiceAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getMarketSegment() {
		return marketSegment;
	}

	public void setMarketSegment(String marketSegment) {
		this.marketSegment = marketSegment;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Long getCustomerId() {
		return customerId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", industryId=" + industryId + ", marketSegmentId="
				+ marketSegmentId + ", dateCreated=" + dateCreated + ", name=" + name + ", deliveryAddress="
				+ deliveryAddress + ", invoiceAddress=" + invoiceAddress + ", emailAddress=" + emailAddress
				+ ", cellPhone=" + cellPhone + ", industry=" + industry + ", marketSegment=" + marketSegment
				+ ", region=" + region + "]";
	}

	
	
	
	
}
