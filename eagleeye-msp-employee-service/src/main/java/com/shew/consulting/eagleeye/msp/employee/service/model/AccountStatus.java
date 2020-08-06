package com.shew.consulting.eagleeye.msp.employee.service.model;

/**
 * Enum to represent the state of an account.
 */
public enum AccountStatus {
    ACTIVE,
    LOCKED;

    public boolean isActive() {
        return this == AccountStatus.ACTIVE;
    }

}
