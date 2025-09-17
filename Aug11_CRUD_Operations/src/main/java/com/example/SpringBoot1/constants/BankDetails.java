package com.example.SpringBoot1.constants;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "banking.cluster.details")
public class BankDetails {

    private String name;
    private String ifsc;
    private String branch;
    private String city;
    private String state;

}
