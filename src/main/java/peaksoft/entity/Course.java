package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courses_gen")
    @SequenceGenerator(name = "courses_gen", sequenceName = "courses_seq", allocationSize = 1)

    private Long id;
    private String courseName;
    private LocalDate dateOfStart;
    private String description;

    @ManyToOne
    private Company company;

    @OneToMany(mappedBy = "course")
    private List<Instructor> instructorList;

    @ManyToMany(mappedBy = "courseList")
    private List<Group>groups;

    @OneToMany(mappedBy = "course")
    private List<Lesson>lessons;
}
