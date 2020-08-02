package com.shew.consulting.eagleeye.msp.employee.service.model;

public enum AccountStatus {
    ACTIVE,
    LOCKED;

    public boolean isActive() {
        return this == AccountStatus.ACTIVE;
    }

}
