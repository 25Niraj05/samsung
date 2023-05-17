//package com.pwc.nic.config;
//
//import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.sql.DataSource;
//import java.util.Map;
//
//public class DataSourceMultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {
//
//	private static final long serialVersionUID = 1L;
//
//	@Autowired
//	private Map<String, DataSource> dataSources;
//
//	@Override
//	protected DataSource selectAnyDataSource() {
//		return this.dataSources.values().iterator().next();
//	}
//
//	@Override
//	protected DataSource selectDataSource(String tenantIdentifier) {
//		return this.dataSources.get(tenantIdentifier);
//	}
//}