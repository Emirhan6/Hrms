package hrms.hrmsDatabase.business.abstracts;

//import java.time.LocalDate;
import java.util.List;

import hrms.hrmsDatabase.core.utilities.results.DataResult;
import hrms.hrmsDatabase.core.utilities.results.Result;
import hrms.hrmsDatabase.entities.concretes.Cv;

public interface CvService {
	DataResult<List<Cv>> getAll();
	Result add(Cv cv);
	DataResult<Cv> getByJobSeeker(int userId);
	//DataResult<List<Cv>> getSortedByGraduationYear(String graduationYear);
	//DataResult<List<Cv>> getSortedByExperienceDateFinish(String experienceDateFinish);
}
