package hrms.hrms_backend.api.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hrms.hrms_backend.business.abstracts.AuthService;
import hrms.hrms_backend.core.utilities.result.ErorDataResult;
import hrms.hrms_backend.core.utilities.result.Result;
import hrms.hrms_backend.entities.dtos.EmployerRegisterDto;
import hrms.hrms_backend.entities.dtos.JobSeekerRegisterDto;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        super();
        this.authService = authService;
    }

    @PostMapping("/jobseekerregister")
    public Result jobSeekerRegister(@RequestBody JobSeekerRegisterDto jobSeekerRegisterDto) {
        return this.authService.registerJobSeeker(jobSeekerRegisterDto);
    }

    @PostMapping("/employerregister")
    public Result registerEmployer(@RequestBody EmployerRegisterDto employerRegisterDto) {
        return this.authService.registerEmployer(employerRegisterDto);
    }

    @GetMapping("/verify")
    public Result verify(int userId, String verificationCode) {
        return this.authService.verifyEmail(userId, verificationCode);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErorDataResult<Object> errors = new ErorDataResult<Object>(validationErrors, "Validation error. Try again ! ");

        return errors;

    }
}
