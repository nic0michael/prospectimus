package za.co.prospectimus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.prospectimus.model.Gratuity;

public interface GratuityRepository extends JpaRepository<Gratuity, Long> {

	public Gratuity findByGratuityId(Long gratuityId);

}
