package atm.config;

import atm.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ATMConfig {

    @Bean
    public DataSourceWebAPI dataSourceDB(){
        return new DataSourceWebAPI();
    }

    @Bean
    public Bank bank(){
        return new atm.Bank("My Bank", dataSourceDB());
    }

    @Bean
    public ATM atm() {
        return new atm.ATM(bank());
    }

    @Bean
    public AtmUI atmUI(){
        return new AtmUI(atm());
    }

}
