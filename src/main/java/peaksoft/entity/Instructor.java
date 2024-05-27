package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

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
    private String specializatoin;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Course course;

}
