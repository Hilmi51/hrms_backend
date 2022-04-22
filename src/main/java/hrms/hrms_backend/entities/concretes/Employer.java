package hrms.hrms_backend.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employer")
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Employer extends User {

    @Column(name = "employer_company_name")
    private String companyName;

    @Column(name = "employer_website")
    private String employerWebsite;

    @Column(name = "employer_phone_number")
    private String employerPhoneNumber;

    @Column(name = "employer_email")
    private String employerEmail;

    @Nullable
    @Column(name = "is_email_verified", columnDefinition = "boolean default false")
    private Boolean isEmailVerified;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;

}
