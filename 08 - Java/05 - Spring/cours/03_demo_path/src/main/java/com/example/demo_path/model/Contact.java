package com.example.demo_path.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private UUID id;
    private String name;
    private String phone;
    private int age;
}
