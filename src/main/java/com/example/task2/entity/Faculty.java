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
public class Faculty extends TemplateEntity {

    @ManyToOne(optional = false)
    private University university;

    @OneToMany(mappedBy = "faculty",cascade = CascadeType.REMOVE)
    private List<Group> groups;
}
