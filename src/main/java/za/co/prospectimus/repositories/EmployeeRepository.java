package za.co.prospectimus.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import za.co.prospectimus.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public Employee findByEmployeeId(Long employeeId);



}

