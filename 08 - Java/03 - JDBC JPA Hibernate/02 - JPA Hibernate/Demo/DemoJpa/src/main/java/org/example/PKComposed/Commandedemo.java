package org.example.PKComposed;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Commandedemo {
    @Id
//    private CommandePK commandePK;

    private String customer;
    private LocalDate commandDate;

}
