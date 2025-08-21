package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_sender_account")
    private Account senderAccount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_receiver_account")
    private Account receiverAccount;
    private LocalDateTime date;
    private float amount;
}
