package com.example.task2.entity;

import com.example.task2.entity.template.TemplateEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "groups")
public class Group extends TemplateEntity {

    @Column(nullable = false, name = "year")
    private Integer year;

    @ManyToOne
    private Faculty faculty;

    @OneToMany(mappedBy = "group", cascade = CascadeType.REMOVE)
    private List<Student> students;

    @OneToOne(mappedBy = "group",cascade = CascadeType.REMOVE)
    private Journal journal;

    @OneToMany(mappedBy = "group", cascade = CascadeType.REMOVE)
    private List<Subject> subjects;

    @Transient
    private Integer countOfStudents;

    public Integer getCountOfStudents() {
        if (this.students!=null){
            this.countOfStudents=students.size();
        }
        return this.countOfStudents;
    }
}
