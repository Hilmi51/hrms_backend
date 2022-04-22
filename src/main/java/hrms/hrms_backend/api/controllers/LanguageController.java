package hrms.hrms_backend.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms_backend.business.abstracts.LanguageService;
import hrms.hrms_backend.core.utilities.result.DataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.concretes.Language;

@RestController
@CrossOrigin
@RequestMapping("/api/language")
public class LanguageController {
    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        super();
        this.languageService = languageService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid Language language) {
        return this.languageService.add(language);
    }


    @PostMapping("/update")
    public Result update(@RequestBody Language language) {
        return this.languageService.update(language);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Language language) {
        return this.languageService.delete(language);
    }

    @GetMapping("/getall")
    public DataResult<List<Language>> getall(@RequestParam int candidateId) {
        return this.languageService.getAllByCvId(candidateId);
    }
}
