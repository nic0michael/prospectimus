package za.co.prospectimus.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier_order")
public class SupplierOrder {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplier_order_id")
	private Long supplierOrderId;

	@Column(name = "date_created")
	private Timestamp dateCreated;

	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "supplier_id")
	private Long supplierId;
	
	@Column(name = "supplier_name")
	private String supplierName;

	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "quantity")
	private Long quantity;
	
	@Column(name = "name", length=256)
	private String name;
	
	@Column(name = "cost_price")
	private Double costPrice;



	@Column(name = "invoiced")
	private Boolean invoiced=false;
	
	@Column(name = "delivered")
	private Boolean delivered=false;
	

	@Column(name = "payed")
	private Boolean payed=false;
	
	@Column(name = "invoice_number", length=256)
	private String invoiceNumber;

	
	

	public Boolean getInvoiced() {
		return invoiced;
	}

	public void setInvoiced(Boolean invoiced) {
		this.invoiced = invoiced;
	}

	public Boolean getDelivered() {
		return delivered;
	}

	public void setDelivered(Boolean delivered) {
		this.delivered = delivered;
	}

	public Boolean getPayed() {
		return payed;
	}

	public void setPayed(Boolean payed) {
		this.payed = payed;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public Long getSupplierOrderId() {
		return supplierOrderId;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
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

	@Override
	public String toString() {
		return "SupplierOrder [supplierOrderId=" + supplierOrderId + ", dateCreated=" + dateCreated + ", productId="
				+ productId + ", supplierId=" + supplierId + ", supplierName=" + supplierName + ", productName="
				+ productName + ", quantity=" + quantity + ", name=" + name + ", costPrice=" + costPrice + ", invoiced="
				+ invoiced + ", delivered=" + delivered + ", payed=" + payed + ", invoiceNumber=" + invoiceNumber + "]";
	}










	
	
}
