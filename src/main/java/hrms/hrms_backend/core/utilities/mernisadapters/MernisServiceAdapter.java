package hrms.hrms_backend.core.utilities.mernisadapters;

import java.sql.Date;

import org.springframework.stereotype.Service;

import hrms.hrms_backend.core.utilities.fakeMernisService.MernisService;

@Service
public class MernisServiceAdapter implements UserCheckService {

    @Override
    public boolean checkIfRealPerson(long nationalityId, String firstName, String lastName, Date date) {

        MernisService client = new MernisService();
        boolean result = client.TCKimlikDogrula(nationalityId, firstName, lastName, date);
        return result;
    }
}
