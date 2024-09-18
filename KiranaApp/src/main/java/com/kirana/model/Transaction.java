package com.kirana.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private String currency; // e.g., INR, USD
    private LocalDateTime timestamp;
    private boolean isDebit;

    // Getters and setters...
}
