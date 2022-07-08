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
public class Journal extends TemplateEntity {

    @OneToOne
    @JoinColumn(unique = true)
    private Group group;

    @ManyToMany
    private List<Subject> subjects;

    @OneToMany(mappedBy = "journal", cascade = CascadeType.REMOVE)
    private List<Mark> marks;
}
