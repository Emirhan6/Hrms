package hrms.hrmsDatabase.business.concretes;

import java.io.IOException;
import java.util.List;
import java.time.*;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrms.hrmsDatabase.business.abstracts.JobSeekerService;
import hrms.hrmsDatabase.core.utilities.imageUploaders.ImageUploadService;
import hrms.hrmsDatabase.core.utilities.imageUploaders.ImageUploadService;
import hrms.hrmsDatabase.core.utilities.results.DataResult;
import hrms.hrmsDatabase.core.utilities.results.ErrorDataResult;
import hrms.hrmsDatabase.core.utilities.results.ErrorResult;
import hrms.hrmsDatabase.core.utilities.results.Result;
import hrms.hrmsDatabase.core.utilities.results.SuccessDataResult;
import hrms.hrmsDatabase.core.utilities.results.SuccessResult;
import hrms.hrmsDatabase.dataAccess.abstracts.JobSeekerDao;
import hrms.hrmsDatabase.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	private ImageUploadService imageService;
	
	public JobSeekerManager(JobSeekerDao jobSeekerDao,ImageUploadService imageService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.imageService = imageService;
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
/*
	@Override
	public DataResult<JobSeeker> imageUpload(int jobSeekerId, MultipartFile file) throws IOException {
		var jobSeeker = this.jobSeekerDao.getByUserId(jobSeekerId);
		if(jobSeeker == null) {
			return new ErrorDataResult<>(null,"İş Arayan mevcut değil");
		}
		var imageUrl = uploadImageToCloudinary(file, jobSeeker.getImageUrl());
		
		return new SuccessDataResult<>(this.jobSeekerDao.save(jobSeeker));
	}
	
	private  Result uploadImageToCloudinary( MultipartFile file, String imageUrl) throws IOException {
        var result = this.imageService.upload(file);
        if(!result.isSuccess()){
            return new ErrorResult(result.getMessage());
        }
        if(imageUrl != null){
            var imageId = imageUrl.split(("/"))[imageUrl.split(("/")).length - 1].split("\\.")[0];
            this.imageService.delete(imageId);
        }
        var url = result.getData().get("url");
        return new SuccessResult(url.toString());

    }
*/
	@Override
	public Result delete(int id) {
		this.jobSeekerDao.deleteById(id);
		return new SuccessResult("İş Arayan Silindi");
	}

	@Override
	public Result update(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("İş Arayan Güncellendi");
	}

	@Override
	public DataResult<JobSeeker> getById(int id) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getByUserId(id),"Data Getirildi");
		
	}

	@Override
	public DataResult<JobSeeker> getByName(String name) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getByFirstName(name),"Data Getirildi");
	}
}
