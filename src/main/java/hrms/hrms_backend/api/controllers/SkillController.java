package hrms.hrms_backend.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms_backend.business.abstracts.SkillService;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.Skill;

@RestController
@CrossOrigin
@RequestMapping("/api/skill")
public class SkillController {
    private SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        super();
        this.skillService = skillService;
    }


    @PostMapping("/add")
    public Result add(@RequestBody Skill skill) {
        return this.skillService.add(skill);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Skill skill) {
        return this.skillService.update(skill);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Skill skill) {
        return this.skillService.delete(skill);
    }
}
