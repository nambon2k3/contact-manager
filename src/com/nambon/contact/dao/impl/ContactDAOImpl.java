package com.nambon.contact.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.tree.TreePath;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.nambon.contact.dao.ContactDAO;
import com.nambon.contact.model.Contact;

public class ContactDAOImpl implements ContactDAO {
	
	//interact with jdbc
	private JdbcTemplate jbbcTeamplate;
	
	public ContactDAOImpl(DataSource dataSource) {
		// provide data source to get data
		jbbcTeamplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Contact contact) {
		String sql = "INSERT INTO Contact VALUES (?, ?, ?, ?)";
		return jbbcTeamplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(), contact.getPhone());
	}

	@Override
	public int update(Contact contact) {
		String sql = "UPDATE Contact SET name = ?, email = ?, address = ?, phone = ? WHERE id = ?";
		return jbbcTeamplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(), contact.getPhone(), contact.getId());
	}

	@Override
	public Contact get(Integer id) {
		String sql = "SELECT * FROM Contact WHERE id = " + id;
		ResultSetExtractor<Contact> extractor = new ResultSetExtractor<Contact>() {
			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String email = rs.getString("email");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					return new Contact(id, name, email, address, phone);
				}
				return null;
			}
		};
		return jbbcTeamplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM Contact WHERE id = " + id;
		return jbbcTeamplate.update(sql);
	}

	@Override
	public List<Contact> list() {
		String sql = "SELECT * FROM Contact";
		List<Contact> listContact = new ArrayList<>();
		RowMapper<Contact> rowMapper = new RowMapper<Contact>() {
			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				return new Contact(id, name, email, address, phone);
			}
			
		};
		return jbbcTeamplate.query(sql, rowMapper);
	}

}
