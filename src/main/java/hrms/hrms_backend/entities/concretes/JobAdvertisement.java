package hrms.hrms_backend.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_advertisement")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "job_application_deadline")
    private String jobApplicationDeadline;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "min_salary")
    private String minSalary;

    @Column(name = "max_salary")
    private String maxSalary;

    @Column(name = "position_caount")
    private String positionCaount;

    @Column(name = "is_active", columnDefinition = "boolean default true")
    @JsonIgnore
    private Boolean isActive = true;

    @Column(name = "is_verified_by_employees", columnDefinition = "boolean default false")
    private Boolean isVerifiedByEmployees = false;

    @Column(name = "is_opened", columnDefinition = "boolean default true")
    private Boolean isOpened = true;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "jobs_id")
    private Jobs jobs;

    @ManyToOne()
    @JoinColumn(name = "employment_type_id")
    private EmploymentType employmentType;
}
