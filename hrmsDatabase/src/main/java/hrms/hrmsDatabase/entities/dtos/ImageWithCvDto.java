package hrms.hrmsDatabase.entities.dtos;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageWithCvDto {
	private int id;
	private String url;
	private String schoolName;
	private String department;
	private String startYear;
	private String graduationYear;
	private String oldWorkplaceName;
	private String oldPosition;
	private String experienceDateStart;
	private String experienceDateFinish;
	private String foreignLanguages;
	private int languageLevel;
	private String githubAccount;
	private String linkedinAccount;
	private String programmingLanguages;
	private String descriptions;
}
