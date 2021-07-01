package hrms.hrmsDatabase.api.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import hrms.hrmsDatabase.business.abstracts.JobSeekerService;
import hrms.hrmsDatabase.core.utilities.results.DataResult;
import hrms.hrmsDatabase.core.utilities.results.Result;
import hrms.hrmsDatabase.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers")
@CrossOrigin
public class JobSeekersController {
	
	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll(){
		return this.jobSeekerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeeker jobSeeker){
		jobSeeker.getBirthDate().toString();
		return this.jobSeekerService.add(jobSeeker);
	}
	
	/*@PostMapping("uploadImage")
    public ResponseEntity<?> uploadImage(@RequestParam int jobSeekerId, @RequestParam MultipartFile file){
        DataResult result = null ;
        try {
            result = this.jobSeekerService.imageUpload(jobSeekerId,file);
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(result);
    }
	*/
	@DeleteMapping("/delete")
	public Result delete(@RequestBody int id) {
		return this.jobSeekerService.delete(id);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody JobSeeker jobSeeker) {
		return this.jobSeekerService.update(jobSeeker);
	}
	
	@GetMapping("/getbyid")
	public DataResult<JobSeeker> getById(@RequestParam int id){
		return this.jobSeekerService.getById(id);
	}
	
	@GetMapping("/getbyname")
	public DataResult<JobSeeker> getById(@RequestParam String name){
		return this.jobSeekerService.getByName(name);
	}
}
