package hrms.hrmsDatabase.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import hrms.hrmsDatabase.business.abstracts.CityService;
import hrms.hrmsDatabase.core.utilities.results.DataResult;
import hrms.hrmsDatabase.core.utilities.results.Result;
import hrms.hrmsDatabase.core.utilities.results.SuccessDataResult;
import hrms.hrmsDatabase.core.utilities.results.SuccessResult;
import hrms.hrmsDatabase.dataAccess.abstracts.CityDao;
import hrms.hrmsDatabase.entities.concretes.City;

@Service
public class CityManager implements CityService{

	private CityDao cityDao;
	
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Şehirler Listelendi");
	}

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult("Şehir Eklendi");
	}

	
}
