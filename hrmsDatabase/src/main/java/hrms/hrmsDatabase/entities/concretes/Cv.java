package hrms.hrmsDatabase.entities.concretes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="cvs")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class Cv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_id")
	private int cvId;
	
	//@Column(name="user_id")
	//private int userId;
	
	@OneToOne()
    @JoinColumn(name = "user_id")
    private JobSeeker jobSeeker;

	@Column(name="school_name")
	private String schoolName;
	
	
	@Column(name="department")
	private String department;
	
	@Column(name="start_year")
	private String startYear;
	
	
	@Column(name="graduation_year")
	private String graduationYear;
	
	
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
	
	//@Column(name="image_url")
	//private String imageUrl;

	
	@Column(name="github_account")
	private String githubAccount;
	
	
	@Column(name="linkedin_account")
	private String linkedinAccount;
	
	
	@Column(name="programming_languages")
	private String programmingLanguages;
	
	
	@Column(name="descriptions")
	private String descriptions;
	
	@OneToOne(mappedBy = "cv")
	private Image image;
}
