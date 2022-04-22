package hrms.hrms_backend.business.abstracts;

import java.util.List;

import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.City;

public interface CityService {

    DataResult<City> getById(int id);

    DataResult<City> getByName(String name);

    DataResult<List<City>> getAll();

    Result add(City city);

    Result update(City city);

    Result delete(City city);
}
