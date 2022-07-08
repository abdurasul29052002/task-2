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
@Entity
public class Student extends TemplateEntity {

    @ManyToOne
    private Group group;

    @OneToMany(mappedBy = "student", cascade = CascadeType.REMOVE)
    private List<Mark> marks;

    @Transient
    private Integer ball;

    public Student(Long id, String name, Integer ball) {
        super(id, name);
        this.ball = ball;
    }
}
