package hrms.hrmsDatabase.dataAccess.abstracts;

//import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsDatabase.entities.concretes.Cv;

public interface CvDao extends JpaRepository<Cv, Integer>{
	//List<Cv> getSortedByGraduationYear(String graduationYear);
	//List<Cv> getSortedByExperienceDateFinish(String experienceDateFinish);
}
