package hrms.hrmsDatabase.business.concretes;

//import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import hrms.hrmsDatabase.business.abstracts.CvService;
import hrms.hrmsDatabase.core.utilities.results.DataResult;
import hrms.hrmsDatabase.core.utilities.results.Result;
import hrms.hrmsDatabase.core.utilities.results.SuccessDataResult;
import hrms.hrmsDatabase.core.utilities.results.SuccessResult;
import hrms.hrmsDatabase.dataAccess.abstracts.CvDao;
import hrms.hrmsDatabase.entities.concretes.Cv;

@Service
public class CvManager implements CvService{

	private CvDao cvDao;
	
	public CvManager(CvDao cvDao) {
		super();
		this.cvDao = cvDao;
	}
	/*
	@Override
	public DataResult<List<Cv>> getSortedByGraduationYear(String graduationYear) {
		Sort sort = Sort.by(Sort.Direction.DESC,"graduationYear");
		if(graduationYear==null) {
			return new SuccessDataResult<List<Cv>>("Eğitimi Devam Ediyor");
		}
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(sort));
	}

	@Override
	public DataResult<List<Cv>> getSortedByExperienceDateFinish(String experienceDateFinish) {
		Sort sort = Sort.by(Sort.Direction.DESC,"graduationYear");
		if(experienceDateFinish==null) {
			return new SuccessDataResult<List<Cv>>("Tecrübesi Devam Ediyor");
		}
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(sort));
	}*/

	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(),"Cv'ler Listelendi");
	}

	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult("Cv Eklendi");
	}

	@Override
	public DataResult<Cv> getByJobSeeker(int userId) {
		return new SuccessDataResult<Cv>(this.cvDao.getByJobSeeker_userId(userId),"Data Getirildi");
	}

	@Override
	public Result update(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult("Cv Güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.cvDao.deleteById(id);
		return new SuccessResult("Cv Silindi");
	}

}
