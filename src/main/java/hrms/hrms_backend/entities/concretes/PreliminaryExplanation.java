package hrms.hrms_backend.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "preliminary_explanation")
@AllArgsConstructor
@NoArgsConstructor
public class PreliminaryExplanation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "explanation")
    private String explanation;

    @ManyToOne()
    @JoinColumn(name = "cv_id")
    private Cv cv;
}
