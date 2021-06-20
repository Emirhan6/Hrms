package hrms.hrmsDatabase.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

@Entity
@Data
@Table(name = "images")
@NoArgsConstructor
@AllArgsConstructor
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id")
	private int imageId;
	
	@Column(name = "url")
	private String url;
	
	@OneToOne(optional=false,fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
	private JobSeeker jobSeeker;
	
	@ManyToOne()
	@JoinColumn(name="cv_id")
	private Cv cv;
}
