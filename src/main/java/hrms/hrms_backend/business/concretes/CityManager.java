package hrms.hrms_backend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms_backend.business.abstracts.CityService;
import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.ErorResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.core.utilities.result.SuccessDataResult;
import hrms.hrms_backend.core.utilities.result.SuccessResult;
import hrms.hrms_backend.dataacceess.abstracts.CityDao;
import hrms.hrms_backend.entities.concretes.City;

@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        super();
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<City> getById(int id) {
        return new SuccessDataResult<City>(
                this.cityDao.getOne(id)
        );
    }

    @Override
    public DataResult<City> getByName(String name) {
        return new SuccessDataResult<City>(
                this.cityDao.findByCityName(name)
        );
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(
                this.cityDao.findAll()
        );
    }

    @Override
    public Result add(City city) {
        if (!this.isCityExists(city.getCityName()).isSuccess()) {
            return new ErorResult("City already exists ! ");
        }
        this.cityDao.save(city);
        return new SuccessResult("City added... ");
    }

    @Override
    public Result update(City city) {
        this.cityDao.save(city);
        return new SuccessResult("City updated... ");
    }

    @Override
    public Result delete(City city) {
        this.cityDao.delete(city);
        return new SuccessResult("City deleted... ");
    }

    public Result isCityExists(String name) {

        if (this.cityDao.findByCityName(name) != null) {
            return new ErorResult();

        }
        return new SuccessResult();
    }
}
