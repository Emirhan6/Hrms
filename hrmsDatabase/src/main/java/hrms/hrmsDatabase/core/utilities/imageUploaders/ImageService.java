package hrms.hrmsDatabase.core.utilities.imageUploaders;

import org.springframework.web.multipart.MultipartFile;

import hrms.hrmsDatabase.core.utilities.results.DataResult;

import java.io.IOException;
import java.util.Map;

public interface ImageService {
	DataResult<Map> upload(MultipartFile multipartFile) throws IOException;
    DataResult<Map> delete (String id) throws IOException;
}
