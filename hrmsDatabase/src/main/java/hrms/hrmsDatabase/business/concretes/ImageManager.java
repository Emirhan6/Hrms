package hrms.hrmsDatabase.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrms.hrmsDatabase.business.abstracts.ImageService;
import hrms.hrmsDatabase.core.utilities.imageUploaders.ImageUploadService;
import hrms.hrmsDatabase.core.utilities.results.*;
import hrms.hrmsDatabase.dataAccess.abstracts.ImageDao;
import hrms.hrmsDatabase.entities.concretes.Image;
import hrms.hrmsDatabase.entities.dtos.ImageWithCvDto;

@Service
public class ImageManager implements ImageService{
	private ImageDao imageDao;
	private ImageUploadService imageUploadService;

	@Autowired
	public ImageManager(ImageDao imageDao, ImageUploadService imageUploadService) {
		super();
		this.imageDao = imageDao;
		this.imageUploadService = imageUploadService;
	}
	
	@Override
	public Result add(Image image , MultipartFile imageFile) {
		Map<String,String> uploadImage = this.imageUploadService.uploadImageFile(imageFile).getData();
		image.setUrl(uploadImage.get("url"));
		this.imageDao.save(image);
		return new SuccessResult("Image has been added.");
	}

	@Override
	public Result update(Image image) {
		this.imageDao.save(image);
		return new SuccessResult("Image has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.imageDao.deleteById(id);
		return new SuccessResult("Image has been deleted.");
	}

	@Override
	public DataResult<Image> getById(int imageId) {
		return new SuccessDataResult<Image>(this.imageDao.getByImageId(imageId));
	}

	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll());
	}

	@Override
	public DataResult<Image> getByJobseekerId(int userId) {
		return new SuccessDataResult<Image>(this.imageDao.getByJobSeeker_userId(userId));
	}

	@Override
	public DataResult<List<ImageWithCvDto>> getImageWithCvDetails() {
		return new SuccessDataResult<List<ImageWithCvDto>>
		(this.imageDao.getImageWithCvDetails(),"Data Listelendi");
	}
}