package hrms.hrms_backend.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms_backend.business.abstracts.LinkService;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.Link;

@RestController
@RequestMapping("/api/link")
public class LinkController {
    private LinkService linkService;

    @Autowired
    public LinkController(LinkService linkService) {
        super();
        this.linkService = linkService;
    }


    @PostMapping("/add")
    public Result add(@RequestBody Link link) {
        return this.linkService.add(link);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Link link) {
        return this.linkService.update(link);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Link link) {
        return this.linkService.delete(link);
    }
}
