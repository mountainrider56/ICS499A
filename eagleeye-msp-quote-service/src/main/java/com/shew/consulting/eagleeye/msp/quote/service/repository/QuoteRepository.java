package com.shew.consulting.eagleeye.msp.quote.service.repository;

import com.shew.consulting.eagleeye.msp.quote.service.model.quote.Quote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Long> {

    List<Quote> findAll();

}
