package hrms.hrmsDatabase.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import hrms.hrmsDatabase.business.abstracts.WorkTypeService;
import hrms.hrmsDatabase.core.utilities.results.*;
import hrms.hrmsDatabase.core.utilities.results.Result;
import hrms.hrmsDatabase.dataAccess.abstracts.WorkTypeDao;
import hrms.hrmsDatabase.entities.concretes.WorkType;

@Service
public class WorkTypeManager implements WorkTypeService{
	
	private WorkTypeDao workTypeDao;

	public WorkTypeManager(WorkTypeDao workTypeDao) {
		super();
		this.workTypeDao = workTypeDao;
	}

	@Override
	public DataResult<List<WorkType>> getall() {
		return new SuccessDataResult<List<WorkType>>(this.workTypeDao.findAll(),"İş Türleri Getirildi");
	}

	@Override
	public Result add(WorkType workType) {
		this.workTypeDao.save(workType);
		return new SuccessResult("İş Türü Eklendi");
	}

}
