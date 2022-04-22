package hrms.hrms_backend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.hrms_backend.business.abstracts.LinkService;
import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.core.utilities.result.SuccessDataResult;
import hrms.hrms_backend.core.utilities.result.SuccessResult;
import hrms.hrms_backend.dataacceess.abstracts.LinkDao;
import hrms.hrms_backend.entities.concretes.Link;

@Service
public class LinkManager implements LinkService {

    private LinkDao linkDao;

    @Autowired
    public LinkManager(LinkDao linkDao) {
        super();
        this.linkDao = linkDao;
    }

    @Override
    public DataResult<List<Link>> getAllByCvId(int jobSeekerId) {
        return new SuccessDataResult<List<Link>>(
                this.linkDao.findAllByCv_Id(jobSeekerId));
    }

    @Override
    public Result add(Link link) {
        this.linkDao.save(link);
        return new SuccessResult("Link added... ");
    }

    @Override
    public Result update(Link link) {
        this.linkDao.save(link);
        return new SuccessResult("Link updated... ");
    }

    @Override
    public Result delete(Link link) {
        this.linkDao.delete(link);
        return new SuccessResult("Link deleted... ");
    }

    @Override
    public DataResult<List<Link>> getAll() {
        return new SuccessDataResult<List<Link>>(
                this.linkDao.findAll()
        );
    }
}
