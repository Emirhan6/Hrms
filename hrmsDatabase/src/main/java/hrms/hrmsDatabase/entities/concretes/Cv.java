package hrms.hrmsDatabase.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="cvs")
@AllArgsConstructor
@NoArgsConstructor
public class Cv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_id")
	private int cvId;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="school_name")
	private String schoolName;
	
	
	@Column(name="department")
	private String department;
	
	@Column(name="start_year")
	private LocalDate startYear;
	
	
	@Column(name="graduation_year")
	private LocalDate graduationYear;
	
	
	@Column(name="experience_workplace_name")
	private String oldWorkplaceName;
	
	
	@Column(name="experience_position")
	private String oldPosition;
	
	
	@Column(name="experience_date_start")
	private String experienceDateStart;
	
	
	@Column(name="experience_date_finish")
	private String experienceDateFinish;
	

	@Column(name="foreign_languages")
	private String foreignLanguages;
	
	
	@Column(name="language_level")
	private int languageLevel;
	
	@Column(name="image_url")
	private String imageUrl;

	
	@Column(name="github_account")
	private String githubAccount;
	
	
	@Column(name="linkedin_account")
	private String linkedinAccount;
	
	
	@Column(name="programming_languages")
	private String programmingLanguages;
	
	
	@Column(name="descriptions")
	private String descriptions;
}
