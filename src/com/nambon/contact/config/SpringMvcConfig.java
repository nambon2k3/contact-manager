package com.nambon.contact.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.nambon.contact.dao.ContactDAO;
import com.nambon.contact.dao.impl.ContactDAOImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.nambon.contact")
public class SpringMvcConfig implements WebMvcConfigurer{
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource;
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=HoLaFood");
		dataSource.setUsername("sa");
		dataSource.setPassword("123");
		return dataSource;
	}
	
	//map the logical view name with the physical view file
	@Bean
	public ViewResolver getViewResovler() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	//create the implementation for the contactDAO
	@Bean
	public ContactDAO getContactDAO() {
		ContactDAO contactDAO = new ContactDAOImpl(getDataSource());
		return contactDAO;
	}
	
}
