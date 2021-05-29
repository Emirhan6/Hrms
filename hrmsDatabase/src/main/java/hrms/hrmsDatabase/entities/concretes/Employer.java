package hrms.hrmsDatabase.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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

public class Employer extends User{
	@Id
	@Column(name="user_id")
	private int userId;
	
	
	@Column(name="company_name")
	private String companyName;
	
	
	@Column(name="web_site")
	private String webSite;
	
	
	@Column(name="telephone")
	private String telephone;
}
