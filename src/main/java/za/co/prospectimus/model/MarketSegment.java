package za.co.prospectimus.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "market_segment")
public class MarketSegment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "market_segment_id")
	private Long marketSegmentId;

	@Column(name = "date_created")
	private Timestamp dateCreated;
	
	@Column(name = "name", length=256)
	private String name;
	
	@Column(name = "description", length=256)
	private String description;

	
	@Column(name = "comments", length=2056)
	private String comments;
	
	
	



	
	
}
