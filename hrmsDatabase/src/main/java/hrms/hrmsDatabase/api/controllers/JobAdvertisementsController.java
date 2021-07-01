package hrms.hrmsDatabase.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsDatabase.business.abstracts.JobAdvertisementService;
import hrms.hrmsDatabase.core.utilities.results.DataResult;
import hrms.hrmsDatabase.core.utilities.results.Result;
import hrms.hrmsDatabase.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
@CrossOrigin
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement){
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PutMapping("/deactive")
	public Result deactive(@RequestBody JobAdvertisement jobAdvertisement){
		return this.jobAdvertisementService.deactive(jobAdvertisement);
	}
	
	@GetMapping("/getallactive")
	public DataResult<List<JobAdvertisement>> findByIsActiveTrue(){
		return this.jobAdvertisementService.findByIsActiveTrue();
	}
	
	@GetMapping("/getbyemployer")
	public DataResult<List<JobAdvertisement>> getByEmployer(@RequestParam int employerId){
		return this.jobAdvertisementService.getByEmployer(employerId);
	}
	
	@GetMapping("/getbyworktime")
	public DataResult<List<JobAdvertisement>> getByWorkTime(@RequestParam String workTime){
		return this.jobAdvertisementService.getByWorkTime(workTime);
	}
	
	@GetMapping("/getbyworktype")
	public DataResult<List<JobAdvertisement>> getByWorkType(@RequestParam String workType){
		return this.jobAdvertisementService.getByWorkType(workType);
	}
	
	@GetMapping("/getbycity")
	public DataResult<List<JobAdvertisement>> getByCity(@RequestParam String cityName){
		return this.jobAdvertisementService.getByCity(cityName);
	}
	
}
