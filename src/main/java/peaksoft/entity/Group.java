package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "groups")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groups_gen")
    @SequenceGenerator(name = "groups_gen", sequenceName = "groups_seq", allocationSize = 1)

    private Long id;
    private String groupName;
    private String imageLink;
    private String description;

    @ManyToMany(cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE})
    private List<Course> courseList;

    @OneToMany(mappedBy = "group", cascade = {CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE})
    private List<Student> students;

}
