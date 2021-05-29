package hrms.hrmsDatabase.business.abstracts;

import hrms.hrmsDatabase.core.utilities.results.Result;
import hrms.hrmsDatabase.entities.concretes.Employer;
import hrms.hrmsDatabase.entities.concretes.JobSeeker;

public interface AuthService {
	Result jobSeekerRegister(JobSeeker jobSeeker);
	Result employerRegister(Employer employer);
}
