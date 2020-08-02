package com.shew.consulting.eagleeye.msp.employee.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shew.consulting.eagleeye.msp.employee.service.model.validator.MatchingPasswords;
import com.shew.consulting.eagleeye.msp.employee.service.model.validator.ValidPassword;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@MatchingPasswords
@JsonIgnoreProperties(ignoreUnknown=true)
public class EmployeeSave extends EmployeeUpdate {

    private String password2;

    @Override
    @ValidPassword
    @JsonIgnore(false)
    @NotEmpty(message = "Password is required")
    public String getPassword() {
        return super.getPassword();
    }

}
