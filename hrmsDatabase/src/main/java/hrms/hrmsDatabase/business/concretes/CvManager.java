package hrms.hrmsDatabase.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hrms.hrmsDatabase.business.abstracts.CvService;
import hrms.hrmsDatabase.core.utilities.results.DataResult;
import hrms.hrmsDatabase.core.utilities.results.SuccessDataResult;
import hrms.hrmsDatabase.dataAccess.abstracts.CvDao;
import hrms.hrmsDatabase.entities.concretes.Cv;

@Service
public class CvManager implements CvService{

	private CvDao cvDao;
	
	public CvManager(CvDao cvDao) {
		super();
		this.cvDao = cvDao;
	}

	@Override
	public DataResult<List<Cv>> getSortedByGraduationYear(LocalDate graduationYear) {
		Sort sort = Sort.by(Sort.Direction.DESC,"graduationYear");
		if(graduationYear==null) {
			return new SuccessDataResult<List<Cv>>("Eğitimi Devam Ediyor");
		}
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(sort));
	}

	@Override
	public DataResult<List<Cv>> getSortedByExperienceDateFinish(LocalDate experienceDateFinish) {
		Sort sort = Sort.by(Sort.Direction.DESC,"graduationYear");
		if(experienceDateFinish==null) {
			return new SuccessDataResult<List<Cv>>("Tecrübesi Devam Ediyor");
		}
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(sort));
	}

}
