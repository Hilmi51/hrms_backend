package hrms.hrms_backend.core.utilities.mernisadapters;

import java.sql.Date;

public interface UserCheckService {

    boolean checkIfRealPerson(long nationalityId, String firstName, String lastName, Date date);
}
