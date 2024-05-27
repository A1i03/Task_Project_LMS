package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import peaksoft.enums.StudyFormat;

@Entity
@Table(name = "students")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "students_gen")
    @SequenceGenerator(name = "students_gen", sequenceName = "students_seq", allocationSize = 1)

    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Column(unique = true)
    private  String email;
    private StudyFormat studyFormat;


    @ManyToOne
    private Group group;
}
