package hrms.hrmsDatabase.core.utilities.adapters;

import hrms.hrmsDatabase.employeeVerification.EmployeeVerification;
import hrms.hrmsDatabase.entities.concretes.Employer;

public class EmployeeVerificationAdapter implements EmployeeVerificationService{

	@Override
	public boolean verification(Employer employer) {
		
		EmployeeVerification employeeVerification = new EmployeeVerification();
		
		if(employeeVerification.verification(employer)) {
			return true;
		}
		return false;
	}

}
