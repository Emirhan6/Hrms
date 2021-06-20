package hrms.hrmsDatabase.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="advertisement_id")
	private int advertisementId;
	
	
	//@Column(name="position_name")
	//private String positionName;
	
	
	@Column(name="job_description")
	private String jobDescription;
	
	
	//@Column(name="city_name")
	//private String cityName;
	
	
	@Column(name="min_salary")
	private int minSalary;
	
	
	@Column(name="max_salary")
	private int maxSalary;
	
	
	@Column(name="number_of_open_position")
	private int numberOfOpenPosition;
	
	
	@Column(name="application_deadline")
	private String applicationDeadline;
	
	@Column(name="release_date")
	private String releaseDate;
	
	
	@Column(name="is_active")
	private boolean isActive;
	
	//@Column(name="")
	//private String typeOfWork;
	
	@OneToOne()
	@JoinColumn(name="work_type_id")
	private WorkType workType;
	
	@OneToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;

	@ManyToOne()
	@JoinColumn(name="position_id")
	private Position position;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
}


