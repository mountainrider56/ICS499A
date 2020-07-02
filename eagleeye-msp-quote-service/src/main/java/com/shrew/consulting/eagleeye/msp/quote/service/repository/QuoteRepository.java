package com.shrew.consulting.eagleeye.msp.quote.service.repository;

import com.shrew.consulting.eagleeye.msp.quote.service.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
