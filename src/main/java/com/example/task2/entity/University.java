package com.example.task2.entity;

import com.example.task2.entity.template.TemplateEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class University extends TemplateEntity {

    @Column(nullable = false, name = "address")
    private String address;

    @Column(nullable = false, name = "open_year")
    private Integer openYear;

    @OneToMany(mappedBy = "university",cascade = CascadeType.REMOVE)
    private List<Faculty> faculties;
}
