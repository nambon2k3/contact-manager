package com.nambon.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.nambon.contact.dao.impl.ContactDAOImpl;
import com.nambon.contact.model.Contact;

class ContactDAOTest {
	
	private DriverManagerDataSource dataSource;
	private ContactDAO contactDAO;
	
	@BeforeEach
	void getConnect() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=HoLaFood");
		dataSource.setUsername("sa");
		dataSource.setPassword("123");
		contactDAO = new ContactDAOImpl(dataSource);
	}
	
	@Test
	void testSave() {
		Contact contact = new Contact("Can Ngoc Huyen", "cnhuyen2003@gmail.com", "LaiThuong", "1234567890");
		int result = contactDAO.save(contact);
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Contact contact = new Contact(1,"Nguyen Viet Hoai Nam", "nambon2k3@gmail.com", "KimQuan", "1234567890");
		int result = contactDAO.update(contact);
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		int id = 1;
		assertNotNull(contactDAO.get(1));;
	}

	@Test
	void testDelete() {
		int id = 2;
		int result = contactDAO.delete(id);
		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Contact> listContact = contactDAO.list();
		assertTrue(!listContact.isEmpty());
	}

}
