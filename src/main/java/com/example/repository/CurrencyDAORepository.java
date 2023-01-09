package com.example.repository;

import com.example.entity.CurrencyDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CurrencyDAORepository extends JpaRepository<CurrencyDAO, Integer> {
    CurrencyDAO findFirstByCurrencyAbbreviationContaining(String abbrev);

    @Query(value = "SELECT c.currencyAbbreviation FROM CurrencyDAO as c")
    List<String> getAbbrevList();
}
