package hrms.hrmsDatabase.core.utilities.imageUploaders;

import org.springframework.web.multipart.MultipartFile;

import hrms.hrmsDatabase.core.utilities.results.DataResult;

import java.util.Map;

public interface ImageUploadService {
	DataResult<Map> uploadImageFile(MultipartFile imageFile);
}
