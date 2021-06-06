package hrms.hrmsDatabase.api.controllers;

//import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsDatabase.business.abstracts.CvService;

import hrms.hrmsDatabase.entities.concretes.Cv;

@RestController
@RequestMapping("/api/cvs")
public class CvsController {

	private CvService cvService;

	public CvsController(CvService cvService) {
		super();
		this.cvService = cvService;
	}
	
	@GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        var result = this.cvService.getAll();
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
	
	@PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Cv cv){
        var result = this.cvService.add(cv);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
	
	/*@GetMapping("/getSortedByGraduationYear")
	public DataResult<List<Cv>> getSortedByGraduationYear(String graduationYear){
		return this.cvService.getSortedByGraduationYear(graduationYear);
	}
	
	@GetMapping("/getSortedByExperienceDateFinish")
	public DataResult<List<Cv>> getSortedByExperienceDateFinish(String experienceDateFinish){
		return this.cvService.getSortedByExperienceDateFinish(experienceDateFinish);
	}*/
}
