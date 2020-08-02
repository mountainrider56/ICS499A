package com.shew.consulting.eagleeye.msp.employee.service.repository;

import com.shew.consulting.eagleeye.msp.employee.service.model.LoginAttempt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Create a repository for login attempt class.
 */
@Repository
public interface LoginAttemptRepository extends CrudRepository<LoginAttempt, Long>  {
}
