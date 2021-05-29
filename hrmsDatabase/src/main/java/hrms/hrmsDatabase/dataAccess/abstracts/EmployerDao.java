package hrms.hrmsDatabase.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsDatabase.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer,Integer>{

}
