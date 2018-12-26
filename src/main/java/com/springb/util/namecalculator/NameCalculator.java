package com.springb.util.namecalculator;

import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;

public class NameCalculator {

    private Gender gender;

    public NameCalculator(@NotNull Gender gender) {
        this.gender = gender;
    }

    public String calculateName(String basicName) {
        StringBuilder sb = new StringBuilder();
        switch (gender) {
            case MAIL:
                sb.append("Mr. ");
                break;
            case FEMAIL:
                sb.append("Ms. ");
                break;
        }

        sb.append(StringUtils.isEmpty(basicName) ? "Unknown" : basicName);
        return sb.toString();
    }
}
