package za.co.prospectimus.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_order")
public class CustomerOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_order_id")
	private Long customerOrderId;

	@Column(name = "date_created")
	private Timestamp dateCreated;
	
	@Column(name = "employee_id")
	private Long employeeId;
	
	@Column(name = "employee_fullname", length=256)
	private String employeeFullname;
	
	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name = "customer_name", length=256)
	private String customerName;

	@Column(name = "product_id")
	private Long productId;

	@Column(name = "product_name", length=256)
	private String productName;
	
	@Column(name = "quantity")
	private Long quantity;
	
	@Column(name = "name", length=256)
	private String name;

	@Column(name = "customer_requirements", length=2048)
	private String customerRequirements;

	@Column(name = "selling_price")
	private Double sellingPrice;

	@Column(name = "gratuity")
	private Double gratuity;


	@Column(name = "order_completed")
	private Boolean orderCompleted=false;


	@Column(name = "invoiced")
	private Boolean invoiced=false;
	

	@Column(name = "payed")
	private Boolean payed=false;
	

	@Column(name = "withdrawn_from_store")
	private Boolean withdrawnFromStore=false;


	
	
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

	public Long getCustomerOrderId() {
		return customerOrderId;
	}

	@Override
	public String toString() {
		return "CustomerOrder [customerOrderId=" + customerOrderId + ", dateCreated=" + dateCreated + ", employeeId="
				+ employeeId + ", employeeFullname=" + employeeFullname + ", customerId=" + customerId
				+ ", customerName=" + customerName + ", productId=" + productId + ", productName=" + productName
				+ ", quantity=" + quantity + ", name=" + name + ", customerRequirements=" + customerRequirements
				+ ", sellingPrice=" + sellingPrice + ", gratuity=" + gratuity + ", orderCompleted=" + orderCompleted
				+ ", invoiced=" + invoiced + ", payed=" + payed + "]";
	}


	
	












	
	
}
