package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private int id;
    private String firstname;
    private String lastname;
    private int classNumber;
    private LocalDate diplomeDate;

}
