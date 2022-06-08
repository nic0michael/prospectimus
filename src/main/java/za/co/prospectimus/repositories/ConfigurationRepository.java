package za.co.prospectimus.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.prospectimus.model.Configuration;

public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {

	public Configuration findByConfigurationId(Long configurationId);

}
