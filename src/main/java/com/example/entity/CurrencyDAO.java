package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "currencies")
public class CurrencyDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "abbrev")
    private String currencyAbbreviation;
    @Column(name = "name")
    private String name;
    @Column(name = "denomination")
    private Integer currencyDenomination;
}
