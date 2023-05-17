package com.pwc.nic.config;

import com.pwc.nic.model.AuthToken;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;


@Configuration
@EnableAsync
//@EnableSwagger2
@EnableRedisRepositories(basePackages = { "com.pwc.nic.repository" })
//@EnableConfigurationProperties({ MultiTenantProperties.class, JpaProperties.class })
//@EnableJpaRepositories(basePackages = { "com.pwc.nic.repository" }, transactionManagerRef = "txManager")
@EnableTransactionManagement
public class MultiTenantJpaConfiguration {
	
	@Value("${conection.timeout:300000}")
	private int timeout;

//	@Autowired
//	private JpaProperties jpaProperties;
//
//	@Autowired
//	private org.springframework.core.env.Environment env;
//
//	@Autowired
//	private MultiTenantProperties multiTenantProperties;
//
//	@Bean(name = "dataSources")
//	public Map<String, DataSource> dataSources() {
//		Map<String, DataSource> result = new HashMap<>();
//		for (DataSourceProperties dsProperties : multiTenantProperties.getDataSources()) {
//			HikariConfig config = new HikariConfig();
//			config.setJdbcUrl(dsProperties.getUrl());
//			config.setUsername(dsProperties.getUsername());
//			config.setPassword(dsProperties.getPassword());
//			config.setMaximumPoolSize(5);
//			result.put(dsProperties.getTenantId(), new HikariDataSource(config));
//		}
//		return result;
//	}
//
//	@Bean
//	public MultiTenantConnectionProvider multiTenantConnectionProvider() {
//		return new DataSourceMultiTenantConnectionProviderImpl();
//	}
//
//	@Bean
//	public CurrentTenantIdentifierResolver currentTenantIdentifierResolver() {
//		return new TenanIdentifierResolverImpl();
//	}
//
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
//			MultiTenantConnectionProvider multiTenantConnectionProvider,
//			CurrentTenantIdentifierResolver currentTenantIdentifierResolver) {
//
//		Map<String, Object> hibernateProps = new LinkedHashMap<>();
//		hibernateProps.putAll(this.jpaProperties.getProperties());
//		hibernateProps.put(Environment.MULTI_TENANT, MultiTenancyStrategy.DATABASE);
//		hibernateProps.put(Environment.MULTI_TENANT_CONNECTION_PROVIDER, multiTenantConnectionProvider);
//		hibernateProps.put(Environment.MULTI_TENANT_IDENTIFIER_RESOLVER, currentTenantIdentifierResolver);
//
//		LocalContainerEntityManagerFactoryBean result = new LocalContainerEntityManagerFactoryBean();
//		result.setPackagesToScan("com.pwc.nic");
//		result.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//		result.setJpaPropertyMap(hibernateProps);
//
//		return result;
//	}
//
//	@Bean
//	public EntityManagerFactory entityManagerFactory(LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
//		return entityManagerFactoryBean.getObject();
//	}
//
//	@Bean
//	public PlatformTransactionManager txManager(EntityManagerFactory entityManagerFactory) {
//		JpaTransactionManager transactionManager = new JpaTransactionManager();
//		transactionManager.setEntityManagerFactory(entityManagerFactory);
//		return transactionManager;
//	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate =  new RestTemplateBuilder()
				.setConnectTimeout(timeout)
				.setReadTimeout(timeout)
				.build();
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

//	@Bean
//	public Docket productApi() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.pwc.nic.rest")).paths(PathSelectors.regex("/v1.*"))
//				.build();
//	}
}
