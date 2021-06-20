package hrms.hrmsDatabase.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrmsDatabase.core.utilities.results.*;

import hrms.hrmsDatabase.business.abstracts.WorkTypeService;
import hrms.hrmsDatabase.entities.concretes.WorkType;

@RestController
@RequestMapping("/api/workTypes")
public class WorkTypesController {
	
	private WorkTypeService workTypeService;

	public WorkTypesController(WorkTypeService workTypeService) {
		super();
		this.workTypeService = workTypeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<WorkType>> getAll(){
		return this.workTypeService.getall();
	}
	
	@PostMapping("/add")
	public Result add(WorkType workType) {
		return this.workTypeService.add(workType);
	}
}
