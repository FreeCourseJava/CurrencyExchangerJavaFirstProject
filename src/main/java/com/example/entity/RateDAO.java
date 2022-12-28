package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "rates", schema = "public")
public class RateDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rate")
    private Float rate;

    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "curr_id")
    private CurrencyDAO currency;
}
