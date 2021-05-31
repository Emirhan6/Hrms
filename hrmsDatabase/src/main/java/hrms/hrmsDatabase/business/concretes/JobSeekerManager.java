package hrms.hrmsDatabase.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import hrms.hrmsDatabase.business.abstracts.JobSeekerService;
import hrms.hrmsDatabase.core.utilities.results.DataResult;
import hrms.hrmsDatabase.core.utilities.results.Result;
import hrms.hrmsDatabase.core.utilities.results.SuccessDataResult;
import hrms.hrmsDatabase.core.utilities.results.SuccessResult;
import hrms.hrmsDatabase.dataAccess.abstracts.JobSeekerDao;
import hrms.hrmsDatabase.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("İş Arayan Eklendi");
	}

	@Override
	public DataResult<JobSeeker> getByEmail(String email) {
		return new SuccessDataResult<JobSeeker>
		(this.jobSeekerDao.getByEmail(email),"Data Listelendi");
	}

	@Override
	public DataResult<JobSeeker> getByNationalityId(String nationalityId) {
		return new SuccessDataResult<JobSeeker>
		(this.jobSeekerDao.getByNationalityId(nationalityId),"Data Listelendi");
	}
}
