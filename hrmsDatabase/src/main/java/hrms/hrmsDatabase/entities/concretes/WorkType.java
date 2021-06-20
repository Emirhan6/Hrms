package hrms.hrmsDatabase.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="work_types")
@AllArgsConstructor
@NoArgsConstructor
public class WorkType {
	
	@Id
	@Column(name="work_type_id")
	private int workTypeId;
	
	@Column(name="work_type_name")
	private String workTypeName;
	
	@OneToOne(mappedBy = "workType")
	private JobAdvertisement jobAdvertisements;
}
