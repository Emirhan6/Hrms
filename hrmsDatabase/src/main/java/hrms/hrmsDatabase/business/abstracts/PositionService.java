package hrms.hrmsDatabase.business.abstracts;

import java.util.List;

import hrms.hrmsDatabase.core.utilities.results.DataResult;
import hrms.hrmsDatabase.core.utilities.results.Result;
import hrms.hrmsDatabase.entities.concretes.Position;

public interface PositionService {
	DataResult<List<Position>> getAll();
	Result add(Position position);
	DataResult<Position> getByPositionName(String positionName);
}
