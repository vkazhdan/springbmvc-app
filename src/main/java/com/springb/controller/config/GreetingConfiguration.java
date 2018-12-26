package com.springb.controller.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingConfiguration {

    @Bean
    @Qualifier("MAIL")
    public NameCalculator getMailNameCalculator() {
        return new NameCalculator(Gender.MAIL);
    }

    @Bean
    @Qualifier("FEMAIL")
    public NameCalculator getFemailNameCalculator() {
        return new NameCalculator(Gender.FEMAIL);
    }

}
