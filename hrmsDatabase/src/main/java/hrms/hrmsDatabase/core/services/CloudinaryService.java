/*
package hrms.hrmsDatabase.core.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hrms.hrmsDatabase.core.utilities.imageUploaders.ImageService;


@Service
public class CloudinaryService implements ImageService{
	Cloudinary cloudinary;
	private Map<String, String> valuesMap = new HashMap<>();
		
		public CloudinaryService() {
			valuesMap.put("cloud_name","dpl502lxz" );
			valuesMap.put("api_key", "312588743187247" );
			valuesMap.put("api_secret","OO6nZ7Ai25ZFl2LfRHHV4lhNJJE" );
			cloudinary = new Cloudinary(valuesMap);
		}
		
		public Map upload (MultipartFile multipartFile) throws IOException {
			File file = convert(multipartFile);
			Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
			file.delete();
			return result;
		}
		
		public Map delete (String id) throws IOException {
			Map result = cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
			return result;
		}
		
		
		private File convert(MultipartFile multipartFile) throws IOException {
			File file = new File(multipartFile.getOriginalFilename());
			FileOutputStream stream = new FileOutputStream(file);
			stream.write(multipartFile.getBytes());
			stream.close();
			
			return file;
		}
}
*/