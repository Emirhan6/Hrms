package hrms.hrmsDatabase.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsDatabase.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Integer>{

}
