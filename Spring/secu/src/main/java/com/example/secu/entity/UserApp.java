package com.example.secu.entity;


import com.example.secu.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;
    private String phone;

    private String password;

    private Role role;


    public UserApp(String firstName, String lastName, String email, String phone, String password, int role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.role = role == 0 ? Role.ROLE_USER : Role.ROLE_ADMIN;
    }
}
