package hrms.hrmsDatabase.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.hrmsDatabase.entities.concretes.Position;

public interface PositionDao extends JpaRepository<Position,Integer>{
	
	Position getByPositionName(String positionName);
}
