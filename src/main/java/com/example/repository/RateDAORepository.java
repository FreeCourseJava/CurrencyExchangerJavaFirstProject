package com.example.repository;

import com.example.entity.RateDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateDAORepository extends JpaRepository<RateDAO, Integer> {
    RateDAO findFirstByCurrencyIdAndDateContaining(Integer id, String date);
}
