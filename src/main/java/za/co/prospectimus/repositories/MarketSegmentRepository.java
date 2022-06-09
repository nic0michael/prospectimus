package za.co.prospectimus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.prospectimus.model.MarketSegment;

public interface MarketSegmentRepository extends JpaRepository<MarketSegment, Long> {

	public MarketSegment findByMarketSegmentId(Long marketSegmentId);

}
