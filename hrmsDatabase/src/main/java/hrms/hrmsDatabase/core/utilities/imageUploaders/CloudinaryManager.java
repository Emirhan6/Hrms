package hrms.hrmsDatabase.core.utilities.imageUploaders;

import com.cloudinary.Cloudinary;

import hrms.hrmsDatabase.core.utilities.results.*;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryManager implements ImageService {

    Cloudinary cloudinary;
    private Map<String, String> valuesMap = new HashMap<>();

    public CloudinaryManager() {
        valuesMap.put("cloud_name","dpl502lxz" );
        valuesMap.put("api_key", "312588743187247" );
        valuesMap.put("api_secret","OO6nZ7Ai25ZFl2LfRHHV4lhNJJE-SFU0" );
        cloudinary = new Cloudinary(valuesMap);
    }

    public DataResult<Map> upload (MultipartFile multipartFile) throws IOException {
        Map<String , Object > options = new HashMap<>();
        var allowedFormats = Arrays.asList("png","jpg","jpeg");
        options.put("allowed_formats",allowedFormats);
        File file = convert(multipartFile);
        Map result= null;
        try {
             result = cloudinary.uploader().upload(file, options);
        }catch (Exception e){
            return new ErrorDataResult<>(e.getMessage());
        }finally {
            file.delete();
        }

        return new SuccessDataResult<>(result);
    }

    public DataResult<Map> delete (String id) throws IOException {
        Map<String , Boolean> options = new HashMap<>();
        options.put("invalidate",true);
        Map result = cloudinary.uploader().destroy(id,options);
        return new SuccessDataResult<>(result);
    }


    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();

        return file;
    }

}