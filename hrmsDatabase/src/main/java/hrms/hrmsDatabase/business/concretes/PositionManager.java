package hrms.hrmsDatabase.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import hrms.hrmsDatabase.business.abstracts.PositionService;
import hrms.hrmsDatabase.core.utilities.results.DataResult;
import hrms.hrmsDatabase.core.utilities.results.ErrorResult;
import hrms.hrmsDatabase.core.utilities.results.Result;
import hrms.hrmsDatabase.core.utilities.results.SuccessDataResult;
import hrms.hrmsDatabase.core.utilities.results.SuccessResult;
import hrms.hrmsDatabase.dataAccess.abstracts.PositionDao;
import hrms.hrmsDatabase.entities.concretes.Position;

@Service
public class PositionManager implements PositionService{

	private PositionDao positionDao;
	
	public PositionManager(PositionDao positionDao) {
		super();
		this.positionDao = positionDao;
	}

	@Override
	public DataResult<List<Position>> getAll() {
		return new SuccessDataResult<List<Position>>(this.positionDao.findAll(),"Data Listelendi");
	}

	@Override
	public Result add(Position position) {
		
		if(getByPositionName(position.getPositionName()).getData()!=null) {
			return new ErrorResult("Bu Pozisyon Daha Önce Eklenmiiş");
		}
		
		this.positionDao.save(position);
		return new SuccessResult("Pozisyon Eklendi");
	}

	@Override
	public DataResult<Position> getByPositionName(String positionName) {
		return new SuccessDataResult<Position>(this.positionDao.getByPositionName(positionName),"Data Listelendi");
	}

	@Override
	public Result delete(int id) {
		this.positionDao.deleteById(id);
		return new SuccessResult("Pozisyon Silindi");
	}

	@Override
	public Result update(Position position) {
		this.positionDao.save(position);
		return new SuccessResult("Pozisyon Güncellendi");
	}

}
