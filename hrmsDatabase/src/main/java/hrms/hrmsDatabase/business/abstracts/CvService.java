package hrms.hrmsDatabase.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import hrms.hrmsDatabase.core.utilities.results.DataResult;
import hrms.hrmsDatabase.entities.concretes.Cv;

public interface CvService {
	DataResult<List<Cv>> getSortedByGraduationYear(LocalDate graduationYear);
	DataResult<List<Cv>> getSortedByExperienceDateFinish(LocalDate experienceDateFinish);
}
