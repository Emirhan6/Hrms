package hrms.hrmsDatabase.business.concretes;

import hrms.hrmsDatabase.business.abstracts.AuthService;
import hrms.hrmsDatabase.business.abstracts.EmployerService;
import hrms.hrmsDatabase.business.abstracts.JobSeekerService;
import hrms.hrmsDatabase.core.utilities.adapters.EmployeeVerificationService;
import hrms.hrmsDatabase.core.utilities.adapters.MernisService;
import hrms.hrmsDatabase.core.utilities.results.ErrorResult;
import hrms.hrmsDatabase.core.utilities.results.Result;
import hrms.hrmsDatabase.core.utilities.results.SuccessResult;
import hrms.hrmsDatabase.entities.concretes.Employer;
import hrms.hrmsDatabase.entities.concretes.JobSeeker;

public class AuthManager implements AuthService{

	private JobSeekerService jobSeekerService;
	private MernisService mernisService;
	private EmployeeVerificationService employeeVerificationService;
	private EmployerService employerService;
	
	public AuthManager(JobSeekerService jobSeekerService,MernisService mernisService,EmployeeVerificationService employeeVerificationService,EmployerService employerService){
		super();
		this.jobSeekerService = jobSeekerService;
		this.mernisService = mernisService;
		this.employeeVerificationService = employeeVerificationService;
		this.employerService = employerService;
	}

	@Override
	public Result jobSeekerRegister(JobSeeker jobSeeker) {
		
		if(mernisVerification(jobSeeker.getFirstName(), jobSeeker.getLastName(), jobSeeker.getNationalityId())==false) {
			return new ErrorResult("Mernis Doğrulaması Başarısız");
		}
		
		if(!isBlankInformation1(jobSeeker)) {
			return new ErrorResult("Lütfen Tüm Bilgileri Doldurunuz");
		}
		
		if(isEmailAlreadyExist(jobSeeker.getEmail())==false) {
			return new ErrorResult("Bu Email Zaten Kullanılıyor");
		}
		
		if(isNationalityIdAlreadyExist(jobSeeker.getNationalityId())==false) {
			return new ErrorResult("Bu Kimlik Numarası İle Kayıt Mevcut");
		}
		
		jobSeekerService.add(jobSeeker);
		return new SuccessResult("Kayıt Başarıyla Tamamlandı");
	}

	@Override
	public Result employerRegister(Employer employer) {
		
		if(employeeVerificationService.verification(employer)==false) {
			return new ErrorResult("Personel Doğrulaması Başarısız");
		}
		
		if(!isBlankInformation2(employer)) {
			return new SuccessResult("Lütfen Tüm Bilgileri Doldurunuz");
		}
		
		if(isEmailAlreadyExist(employer.getEmail())==false) {
			return new ErrorResult("Bu Email Zaten Kullanılıyor");
		}
		
		employerService.add(employer);
		return new SuccessResult("Kayıt Başarıyla Tamamlandı");
	}
	
	private boolean isBlankInformation1(JobSeeker jobSeeker) {
		if(jobSeeker.getFirstName()!=null && jobSeeker.getLastName()!=null && jobSeeker.getNationalityId()!=null && jobSeeker.getBirthDate()!=null) {
			return true;
		}
		return false;
	}
	
	private boolean isBlankInformation2(Employer employer) {
		if(employer.getCompanyName()!=null && employer.getTelephone()!=null) {
			return true;
		}
		return false;
	}
	
	private boolean isEmailAlreadyExist(String email) {
		if(jobSeekerService.getByEmail(email).getData()==null) {
			return true;
		}
		return false;
	}
	
	private boolean isNationalityIdAlreadyExist(String nationalityId) {
		if(jobSeekerService.getByNationalityId(nationalityId).getData()==null) {
			return true;
		}
		return false;
	}
	
	private boolean mernisVerification(String firstName,String lastName,String nationalityId) {
		if(mernisService.verificateByMernis(firstName, lastName, nationalityId)){
			return true;
		}
		return false;
	}
}
