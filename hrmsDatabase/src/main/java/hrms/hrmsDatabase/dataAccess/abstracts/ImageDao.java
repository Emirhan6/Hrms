package hrms.hrmsDatabase.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hrms.hrmsDatabase.entities.concretes.Image;
import hrms.hrmsDatabase.entities.dtos.ImageWithCvDto;

public interface ImageDao extends JpaRepository<Image, Integer>{
	
	Image getByImageId(int imageId);
	Image getByJobSeeker_userId(int userId);
	
	@Query("Select new hrms.hrmsDatabase.entities.dtos.ImageWithCvDto(i.id, i.url, c.schoolName, c.department, c.startYear, c.graduationYear, c.oldWorkplaceName, c.oldPosition, c.experienceDateStart, c.experienceDateFinish, c.foreignLanguages, c.languageLevel, c.githubAccount, c.linkedinAccount, c.programmingLanguages, c.descriptions) From Cv c Inner Join c.image i")
	List<ImageWithCvDto> getImageWithCvDetails();
}	
