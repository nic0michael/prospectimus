package za.co.prospectimus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.prospectimus.model.Industry;

public interface IndustryRepository extends JpaRepository<Industry, Long> {

	public Industry findByIndustryId(Long industryId);

}
