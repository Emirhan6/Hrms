package hrms.hrmsDatabase.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import hrms.hrmsDatabase.core.utilities.results.*;
import hrms.hrmsDatabase.core.utilities.results.Result;
import hrms.hrmsDatabase.entities.concretes.JobSeeker;

public interface JobSeekerService {
	
	DataResult<List<JobSeeker>> getAll();
	Result add(JobSeeker jobSeeker);
	Result delete(int id);
	DataResult<JobSeeker> getById(int id);
	DataResult<JobSeeker> getByName(String name);
	Result update(JobSeeker jobSeeker);
	DataResult<JobSeeker> getByEmail(String email);
	DataResult<JobSeeker> getByNationalityId(String nationalityId);
	//DataResult<JobSeeker> imageUpload(int jobSeekerId, MultipartFile file) throws IOException;
}
