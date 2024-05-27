package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "companies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "companies_gen")
    @SequenceGenerator(name = "companies_gen", sequenceName = "companies_seq", allocationSize = 1)

    private Long id;
    private String country;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy = "company")
    private List<Instructor>instructors;

    @OneToMany(mappedBy = "company", cascade = {CascadeType.REMOVE})
    private List<Course>courses;

}
