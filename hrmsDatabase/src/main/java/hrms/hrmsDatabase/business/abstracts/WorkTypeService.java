package hrms.hrmsDatabase.business.abstracts;

import java.util.List;

import hrms.hrmsDatabase.core.utilities.results.*;
import hrms.hrmsDatabase.entities.concretes.WorkType;

public interface WorkTypeService {
	DataResult<List<WorkType>> getall();
	Result add(WorkType workType);
}
