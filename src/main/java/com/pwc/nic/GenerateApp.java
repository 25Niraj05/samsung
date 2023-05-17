package com.pwc.nic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class
        },
                scanBasePackages = {"com.pwc.nic"}
                )
public class GenerateApp {
    @Autowired
    private Environment env;


    public static void main(String[] args)
    {
        try {

            SpringApplication.run(GenerateApp.class, args);
        }catch (Exception e)
        {
            System.out.println(e);
        }
	
    }
}
