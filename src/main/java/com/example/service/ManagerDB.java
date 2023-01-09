package com.example.service;

import com.example.entity.Currency;
import com.example.entity.CurrencyDAO;
import com.example.entity.CurrencyMapper;
import com.example.entity.RateDAO;
import com.example.repository.CurrencyDAORepository;
import com.example.repository.RateDAORepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagerDB implements CurrencyFromRepository {

    private final CurrencyFromWWW currencyFromWWW;
    private final CurrencyDAORepository currencyDAORepository;
    private final RateDAORepository rateDAORepository;

    @Override
    public void dailyUpdateBD(String date) {
        List<Currency> fullList = currencyFromWWW.getCurrencyRates();
        for (Currency current : fullList) {
            CurrencyDAO currencyDAO = currencyDAORepository.
                    findFirstByCurrencyAbbreviationContaining(current.getCurrencyAbbreviation());
            if (currencyDAO == null) {
                currencyDAO = CurrencyMapper.getCurrencyDAO(current);
                currencyDAORepository.save(currencyDAO);
            }
            RateDAO rateDAO = RateDAO.builder()
                    .rate(current.getCurrencyRate())
                    .currency(currencyDAO)
                    .date(LocalDate.now().toString())
                    .build();
            rateDAORepository.save(rateDAO);
        }
    }

    @Override
    public List<Currency> getCurrencyRates() {
        List<Currency> listCurrency = new ArrayList<>();
        if (getRateByCurrencyAndDate("USD", LocalDate.now().toString()) == null) {
            dailyUpdateBD(LocalDate.now().toString());
        }
        List<String> abbrevs = currencyDAORepository.getAbbrevList();
        for (String abbbrev : abbrevs) {
            listCurrency.add(getRateByCurrencyAndDate(abbbrev, LocalDate.now().toString()));
        }

        return listCurrency;
    }

    @Override
    public Currency getRateByCurrencyAndDate(String currencyAbbrev, String date) {
        CurrencyDAO currencyDAO = currencyDAORepository.
                findFirstByCurrencyAbbreviationContaining(currencyAbbrev);
        if (currencyDAO == null) {
            return null;
        }
        RateDAO rateDAO = rateDAORepository.
                findFirstByCurrencyIdAndDateContaining(currencyDAO.getId(), date);
        if (rateDAO == null) {
            return null;
        }
        return CurrencyMapper.getCurrency(currencyDAO, rateDAO);
    }
}
