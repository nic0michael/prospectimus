package za.co.prospectimus.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import za.co.prospectimus.model.Employee;
import za.co.prospectimus.repositories.EmployeeRepository;

@Component
public class EmployeeHelper {

	@Autowired
	EmployeeRepository employeeRep;


	public List<Employee> findAllActiveEmployees() {
		List<Employee> activeEmployees=new ArrayList<>();
		List<Employee> employees=employeeRep.findAll(sortByFullnameAsc());
		for (Employee employee : employees) {
			if(employee!=null && employee.getEnabled()!=0) {
				activeEmployees.add(employee);
			}
		}
		return activeEmployees;
	}




	private Sort sortByFullnameAsc() {
        return new Sort(Sort.Direction.ASC, "fullName");
    }

}
