package hrms.hrmsDatabase.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsDatabase.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer>{

	List<JobAdvertisement> findByIsActiveTrue();
	//List<JobAdvertisement> findByIsActiveTrueOrderReleaseDate(String releaseDate);
	List<JobAdvertisement> getByEmployer(int employerId);
}