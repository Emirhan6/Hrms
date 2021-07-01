package hrms.hrmsDatabase.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name = "user_id")
@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisement","employeeConfirmation"})

public class Employer extends User{
	@Id
	@Column(name="user_id")
	private int userId;
	
	@OneToOne(mappedBy = "employer")
	private JobAdvertisement jobAdvertisement;
	
	
	@Column(name="company_name")
	private String companyName;
	
	
	@Column(name="web_site")
	private String webSite;
	
	
	@Column(name="telephone")
	private String telephone;
}
