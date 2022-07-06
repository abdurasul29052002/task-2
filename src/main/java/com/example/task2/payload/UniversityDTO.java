package com.example.task2.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniversityDTO {
    @JsonProperty(value = "id")
    private Long id;

    @NotNull @JsonProperty(value = "name")
    private String name;

    @NotNull  @JsonProperty(value = "address")
    private String address;

    @NotNull
    @JsonProperty(value = "open_year")
    private Integer openYear;
}
