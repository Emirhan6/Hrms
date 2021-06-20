package hrms.hrmsDatabase.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrms.hrmsDatabase.core.utilities.results.*;
import hrms.hrmsDatabase.entities.concretes.Image;
import hrms.hrmsDatabase.entities.dtos.ImageWithCvDto;

@Service
public interface ImageService {
	Result add(Image image, MultipartFile imageFile);
	Result update(Image image);
	Result delete(int id);
	DataResult<Image> getById(int id);	
	DataResult<List<Image>> getAll();
	DataResult<Image> getByJobseekerId(int id);
	DataResult<List<ImageWithCvDto>> getImageWithCvDetails();
}
