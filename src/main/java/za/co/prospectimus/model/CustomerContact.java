package za.co.prospectimus.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_contact")
public class CustomerContact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_contact_id")
	private Long customerContactId;
	
	@Column(name = "customer_id")
	private Long customerId;	

	@Column(name = "sales_emp_id")
	private Long salespersonEployeeId;
	
	@Column(name = "customer_name", length=256)
	private String customerName;
	
	@Column(name = "salespers_name", length=256)
	private String salespersonName;

	@Column(name = "date_created")
	private Timestamp dateCreated;

	@Column(name = "date_visited")
	private Timestamp dateLastVisited;

	@Column(name = "date_next_visit")
	private Timestamp dateNextVisit;
		
	@Column(name = "fullname", length=256)
	private String fullname;
	
	@Column(name = "branch", length=256)
	private String branch;
	
	@Column(name = "description", length=256)
	private String description;
	
	@Column(name = "comments", length=2056)
	private String comments;
	
	@Column(name = "city", length=256)
	private String city;
	
	@Column(name = "visit_frequency_in_days")
	private Long visitFrequencyInDays;	

	@Column(name = "physical_address", length=2048)
	private String physicalAddress;
	
	@Column(name = "email_address", length=128)
	private String emailAddress;
	
	@Column(name = "cell_phone", length=128)
	private String cellPhone;

	@Column(name = "lead_prospect_or_customer")
	private Long leadProspectOrCustomer;

	@Column(name = "importance")
	private Long importance;

	
	
	

	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public Long getSalespersonEployeeId() {
		return salespersonEployeeId;
	}


	public void setSalespersonEployeeId(Long salespersonEployeeId) {
		this.salespersonEployeeId = salespersonEployeeId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getSalespersonName() {
		return salespersonName;
	}


	public void setSalespersonName(String salespersonName) {
		this.salespersonName = salespersonName;
	}


	public Timestamp getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}


	public Timestamp getDateLastVisited() {
		return dateLastVisited;
	}


	public void setDateLastVisited(Timestamp dateLastVisited) {
		this.dateLastVisited = dateLastVisited;
	}


	public Timestamp getDateNextVisit() {
		return dateNextVisit;
	}


	public void setDateNextVisit(Timestamp dateNextVisit) {
		this.dateNextVisit = dateNextVisit;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public Long getVisitFrequencyInDays() {
		return visitFrequencyInDays;
	}


	public void setVisitFrequencyInDays(Long visitFrequencyInDays) {
		this.visitFrequencyInDays = visitFrequencyInDays;
	}


	public String getPhysicalAddress() {
		return physicalAddress;
	}


	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
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


	public Long getLeadProspectOrCustomer() {
		return leadProspectOrCustomer;
	}


	public void setLeadProspectOrCustomer(Long leadProspectOrCustomer) {
		this.leadProspectOrCustomer = leadProspectOrCustomer;
	}


	public Long getImportance() {
		return importance;
	}


	public void setImportance(Long importance) {
		this.importance = importance;
	}


	public Long getCustomerContactId() {
		return customerContactId;
	}


	@Override
	public String toString() {
		return "CustomerContact [customerContactId=" + customerContactId + ", customerId=" + customerId
				+ ", salespersonEployeeId=" + salespersonEployeeId + ", customerName=" + customerName
				+ ", salespersonName=" + salespersonName + ", dateCreated=" + dateCreated + ", dateLastVisited="
				+ dateLastVisited + ", dateNextVisit=" + dateNextVisit + ", fullname=" + fullname + ", branch=" + branch
				+ ", description=" + description + ", comments=" + comments + ", city=" + city
				+ ", visitFrequencyInDays=" + visitFrequencyInDays + ", physicalAddress=" + physicalAddress
				+ ", emailAddress=" + emailAddress + ", cellPhone=" + cellPhone + ", leadProspectOrCustomer="
				+ leadProspectOrCustomer + ", importance=" + importance + "]";
	}
	
	
	



	
	
}
