package hrms.hrms_backend.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_seeker")
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker extends User {

    @Column(name = "Job_seeker_first_name")
    private String firstName;

    @Column(name = "job_seeker_last_name")
    private String lastName;

    @Column(name = "job_seeker_national_identity")
    private String nationalIdentity;

    @Column(name = "job_seeker_years_of_birth")
    private Date yearsOfBirth;

    @Column(name = "is_verified_by_email", columnDefinition = "boolean default false")
    @Nullable
    private Boolean isEmailVerified;

    @OneToMany(mappedBy = "jobSeeker")
    private List<Cv> cvs;
}
