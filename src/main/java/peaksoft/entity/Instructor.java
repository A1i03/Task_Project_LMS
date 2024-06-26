package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "instructors")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructors_gen")
    @SequenceGenerator(name = "instructors_gen", sequenceName = "instructors_seq", allocationSize = 1)

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String specialization;

    @ManyToMany(cascade = {CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE})
    private List<Company> companies;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE})
    private Course course;

}
