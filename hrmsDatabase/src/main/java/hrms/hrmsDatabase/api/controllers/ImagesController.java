package hrms.hrmsDatabase.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hrms.hrmsDatabase.business.abstracts.ImageService;
import hrms.hrmsDatabase.business.abstracts.JobSeekerService;
import hrms.hrmsDatabase.core.utilities.results.*;
import hrms.hrmsDatabase.entities.concretes.Image;
import hrms.hrmsDatabase.entities.concretes.JobSeeker;
import hrms.hrmsDatabase.entities.dtos.ImageWithCvDto;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImagesController {
	private ImageService imageService;
	private JobSeekerService jobSeekerService;

	@Autowired
	public ImagesController(ImageService imageService, JobSeekerService jobSeekerService) {
		super();
		this.imageService = imageService;
		this.jobSeekerService = jobSeekerService;
	}
	
	@PostMapping(value = "/add")
	public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile){
		JobSeeker jobseeker = this.jobSeekerService.getById(id).getData();
		Image image = new Image();
		image.setJobSeeker(jobseeker);
		return this.imageService.add(image, imageFile);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody Image image){
		return this.imageService.update(image);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.imageService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<Image> getById(@RequestParam("id") int id){
		return this.imageService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Image>> getAll(){
		return this.imageService.getAll();
	}
	
	
	@GetMapping("/getByJobseekerId")
	public DataResult<Image> getByJobseekerId(@RequestParam int id){
		return this.imageService.getByJobseekerId(id);
	}
	
	@GetMapping("/getImageWithCvDetails")
	public DataResult<List<ImageWithCvDto>> getImageWithCvDetails() {
		return this.imageService.getImageWithCvDetails();
	}
}