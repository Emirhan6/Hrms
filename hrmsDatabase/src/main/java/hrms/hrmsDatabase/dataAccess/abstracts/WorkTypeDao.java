package hrms.hrmsDatabase.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsDatabase.entities.concretes.WorkType;

public interface WorkTypeDao extends JpaRepository<WorkType, Integer>{

}
