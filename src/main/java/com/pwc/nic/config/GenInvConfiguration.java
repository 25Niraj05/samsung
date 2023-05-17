package com.pwc.nic.config;

//import com.pwc.nic.model.AuthToken;
//import com.pwc.nic.util.Encryption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;

import com.pwc.nic.model.AuthToken;
import com.pwc.nic.util.Encryption;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@ComponentScan(basePackageClasses = GenInvConfiguration.class)
public class GenInvConfiguration {

	Logger logger = LoggerFactory.getLogger(GenInvConfiguration.class);

	@Autowired
	private Environment env;
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws IllegalStateException, Exception {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(Database.SQL_SERVER/*POSTGRESQL*/ );
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setPackagesToScan("com.pwc.nic");
		em.setDataSource(dataSource());
		Properties jpaProperties = new Properties();
//		jpaProperties.setProperty("hibernate.dialect",
//				env.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", env.getRequiredProperty("spring.jpa.hibernate.ddl-auto"));
		jpaProperties.setProperty("hibernate.show_sql", env.getRequiredProperty("spring.jpa.show-sql"));
		jpaProperties.setProperty("hibernate.format_sql", env.getRequiredProperty("spring.jpa.hibernate.format_sql"));
		jpaProperties.setProperty("hibernate.ejb.naming_strategy",
				env.getRequiredProperty("spring.jpa.hibernate.naming-strategy"));
		jpaProperties.setProperty("hibernate.temp.use_jdbc_metadata_defaults", env.getRequiredProperty("spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults"));
		em.setJpaProperties(jpaProperties);
		return em;
	}

	@Bean
	public DataSource dataSource() throws Exception {
		logger.info("Decrypted password: {}", Encryption.decrypt(env.getRequiredProperty("spring.datasource.password")));
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(env.getRequiredProperty("spring.datasource.url"));
		dataSource.setUsername(env.getRequiredProperty("spring.datasource.username"));
		dataSource.setPassword(Encryption.decrypt(env.getRequiredProperty("spring.datasource.password")));
		return dataSource;
	}
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(emf);

		return manager;
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		for (HttpMessageConverter<?> converter : restTemplate.getMessageConverters()) {
			if (converter instanceof StringHttpMessageConverter) {
				((StringHttpMessageConverter) converter).setWriteAcceptCharset(false);
			}
		}
		return restTemplate;
	}

	@Bean
	public RedisTemplate<String, AuthToken> redisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, AuthToken> template = new RedisTemplate<String, AuthToken>();
		template.setConnectionFactory(connectionFactory);
		return template;
	}
}
