package hrms.hrmsDatabase.core.utilities.adapters;

import hrms.hrmsDatabase.entities.concretes.Employer;

public interface EmployeeVerificationService {
	boolean verification(Employer employer);
}
