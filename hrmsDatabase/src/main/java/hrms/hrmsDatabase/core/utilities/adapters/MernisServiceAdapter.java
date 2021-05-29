package hrms.hrmsDatabase.core.utilities.adapters;

import org.springframework.stereotype.Service;

import hrms.hrmsDatabase.mernis.MernisVerification;

@Service
public class MernisServiceAdapter implements MernisService{

	@Override
	public boolean verificateByMernis(String firstName, String lastName, String nationalityId) {
		MernisVerification mernisVerification = new MernisVerification();
		
		if(mernisVerification.verificate(firstName, lastName, nationalityId)) {
			return true;
		}
		return false;
	}

}
