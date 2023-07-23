package com.example.springboot.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course") // ignore course while calling toString
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false // means this relationship is required can't save course without material
    )
    @JoinColumn(
            name = "course_id", // new column will be added with this name
            referencedColumnName = "courseId"
    )
    private Course course;
}
