package com.example.task2.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarkDTO {
    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "ball")
    private Integer ball;

    @JsonProperty(value = "student")
    private StudentDTO student;

    @JsonProperty(value = "journal")
    private JournalDTO journal;
}
