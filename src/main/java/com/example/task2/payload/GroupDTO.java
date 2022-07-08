package com.example.task2.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupDTO {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "year")
    private Integer year;

    @JsonProperty(value = "faculty")
    private FacultyDTO faculty;

    @JsonProperty(value = "count_of_students")
    private Integer countOfStudents;
}
