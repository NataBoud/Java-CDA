package com.example.demo_bases.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Person {
    private int id;
    private String firstname;
    private String lastname;
}
