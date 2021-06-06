package hrms.hrmsDatabase.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import hrms.hrmsDatabase.business.abstracts.EmployeeService;
import hrms.hrmsDatabase.core.utilities.results.DataResult;
import hrms.hrmsDatabase.core.utilities.results.Result;
import hrms.hrmsDatabase.core.utilities.results.SuccessDataResult;
import hrms.hrmsDatabase.core.utilities.results.SuccessResult;
import hrms.hrmsDatabase.dataAccess.abstracts.EmployeeDao;
import hrms.hrmsDatabase.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployeeDao employeeDao;
	
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Data Getirildi");
	}

	@Override
	public Result add(Employee employee) {
		this.employeeDao.save(employee);
		return new SuccessResult("Çalışan Eklendi");
	}

	@Override
	public Result delete(int id) {
		this.employeeDao.deleteById(id);
		return new SuccessResult("Çalışan Silindi");
	}

	@Override
	public Result update(Employee employee) {
		this.employeeDao.save(employee);
		return new SuccessResult("Çalışan Güncellendi");
	}

}
