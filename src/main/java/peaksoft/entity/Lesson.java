package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "lessons")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lessons_gen")
    @SequenceGenerator(name = "lessons_gen", sequenceName = "lessons_seq", allocationSize = 1)

    private Long id;
    private String lessonName;

    @ManyToOne
    private Course course;

    @OneToMany(cascade = {CascadeType.REMOVE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    private List<Task>tasks;

}
