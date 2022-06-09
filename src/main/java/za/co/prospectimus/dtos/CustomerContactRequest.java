package za.co.prospectimus.dtos;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class CustomerContactRequest {

	private Long customerOrderId;
	private Timestamp dateCreated;
	private Long customerId;
	private String customerName;
	private Long productId;
	private String productName;
	private Long quantity;
	private String name;
	private String customerRequirements;
	private Double sellingPrice;
	private Boolean orderCompleted=false;
	private Boolean invoiced=false;
	private Boolean payed=false;
	private Long employeeId;
	private String employeeFullname;
	private Double gratuity;


	
	
	
	public String getEmployeeFullname() {
		return employeeFullname;
	}
	public void setEmployeeFullname(String employeeFullname) {
		this.employeeFullname = employeeFullname;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Double getGratuity() {
		return gratuity;
	}
	public void setGratuity(Double gratuity) {
		this.gratuity = gratuity;
	}
	public Boolean getOrderCompleted() {
		return orderCompleted;
	}
	public void setOrderCompleted(Boolean orderCompleted) {
		this.orderCompleted = orderCompleted;
	}
	public Boolean getInvoiced() {
		return invoiced;
	}
	public void setInvoiced(Boolean invoiced) {
		this.invoiced = invoiced;
	}
	public Boolean getPayed() {
		return payed;
	}
	public void setPayed(Boolean payed) {
		this.payed = payed;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomerOrderId(Long customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	public Timestamp getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCustomerRequirements() {
		return customerRequirements;
	}
	public void setCustomerRequirements(String customerRequirements) {
		this.customerRequirements = customerRequirements;
	}
	public Double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	@Override
	public String toString() {
		return "CustomerOrderRequest [customerOrderId=" + customerOrderId + ", dateCreated=" + dateCreated
				+ ", customerId=" + customerId + ", customerName=" + customerName + ", productId=" + productId
				+ ", productName=" + productName + ", quantity=" + quantity + ", name=" + name
				+ ", customerRequirements=" + customerRequirements + ", sellingPrice=" + sellingPrice
				+ ", orderCompleted=" + orderCompleted + ", invoiced=" + invoiced + ", payed=" + payed + ", employeeId="
				+ employeeId + ", employeeFullname=" + employeeFullname + ", gratuity=" + gratuity + "]";
	}


	



	

}
