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
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsDatabase.business.abstracts.EmployerService;
import hrms.hrmsDatabase.core.utilities.results.DataResult;
import hrms.hrmsDatabase.core.utilities.results.Result;
import hrms.hrmsDatabase.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {

	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Employer employer){
		return this.employerService.add(employer);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody int id){
		return this.employerService.delete(id);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody Employer employer){
		return this.employerService.update(employer);
	}
	
	
	
}
