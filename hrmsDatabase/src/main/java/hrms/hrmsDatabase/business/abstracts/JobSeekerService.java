package hrms.hrmsDatabase.business.abstracts;

import java.util.List;

import hrms.hrmsDatabase.core.utilities.results.DataResult;
import hrms.hrmsDatabase.core.utilities.results.Result;
import hrms.hrmsDatabase.entities.concretes.JobSeeker;

public interface JobSeekerService {
	
	DataResult<List<JobSeeker>> getAll();
	Result add(JobSeeker jobSeeker);
	DataResult<JobSeeker> getByEmail(String email);
	DataResult<JobSeeker> getByNationalityId(String nationalityId);
}
