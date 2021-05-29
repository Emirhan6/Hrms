package hrms.hrmsDatabase.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsDatabase.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer>{
	
	JobSeeker getByEmail(String email);
	JobSeeker getByNationalityId(String nationalityId);
}
