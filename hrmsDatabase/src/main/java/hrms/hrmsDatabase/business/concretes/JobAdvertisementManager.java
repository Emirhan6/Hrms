package hrms.hrmsDatabase.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import hrms.hrmsDatabase.business.abstracts.JobAdvertisementService;
import hrms.hrmsDatabase.core.utilities.results.DataResult;
import hrms.hrmsDatabase.core.utilities.results.Result;
import hrms.hrmsDatabase.core.utilities.results.SuccessDataResult;
import hrms.hrmsDatabase.core.utilities.results.SuccessResult;
import hrms.hrmsDatabase.dataAccess.abstracts.JobAdvertisementDao;
import hrms.hrmsDatabase.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{
	
	private JobAdvertisementDao jobAdvertisementDao;

	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"İlanlar Listelendi");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İlan Eklendi");
	}

//	@Override
//	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderReleaseDate(String releaseDate) {
//		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrueOrderReleaseDate(releaseDate),"Aktif İlanlar Yayın Tarihine Göre Listelendi");
//	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployer(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployer(employerId),"Data Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrue(),"Aktif İlanlar Listelendi");
	}

	@Override
	public Result close(JobAdvertisement jobAdvertisement) {
		jobAdvertisement.setActive(false);
		return new SuccessResult("İlan Kapatıldı");
	}

}
