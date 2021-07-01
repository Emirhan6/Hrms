package hrms.hrmsDatabase.business.abstracts;

import java.util.List;

import hrms.hrmsDatabase.core.utilities.results.DataResult;
import hrms.hrmsDatabase.core.utilities.results.Result;
import hrms.hrmsDatabase.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> findByIsActiveTrue();
	Result add(JobAdvertisement jobAdvertisement);
	Result deactive(JobAdvertisement jobAdvertisement);
	//DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderReleaseDate(String releaseDate);
	DataResult<List<JobAdvertisement>> getByEmployer(int employerId);
	DataResult<List<JobAdvertisement>> getByWorkTime(String workTime);
	DataResult<List<JobAdvertisement>> getByWorkType(String workType);
	DataResult<List<JobAdvertisement>> getByCity(String workTime);
}