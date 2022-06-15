package com.stoping.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stoping.domain.model.Product;

public class MySqlProductDaoImpl implements ProductDao {

	public MySqlProductDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("jdbc 드라이버 로드 실패");
		}		
	}
	
	@Override
	public List<Product> getAll() {
		List<Product> results = new ArrayList<>();
		
		// 자동 close, java8부터
		String sql = "SELECT * FROM product";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/kopoctc", "root", "kopo37");
				Statement stmt = conn.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					String id = rs.getString(1);
					String name = rs.getString(2);
					int unitPrice = rs.getInt(3);
					String description = rs.getString(4);
					String category = rs.getString(5);
					String manufacturer = rs.getString(6);
					long unitsInStock = rs.getLong(7);
					String condition = rs.getString(8);
					
					Product product = new Product(id, name, unitPrice);
					product.setDescription(description);
					product.setManufacturer(manufacturer);
					product.setCategory(category);
					product.setUnitsInStock(unitsInStock);
					product.setCondition(condition);
					
					results.add(product);
				}
			}
		} catch (SQLException e) {
			//e.getMessage
			throw new IllegalStateException("db 연결 실패");
		}
		
		return results;
	}

	@Override
	public void insert(Product product) {
		// PreparedStatement 동적 쿼리, INSERT UPDATE DELETE 여러번 할 때 고속
		String sql = "INSERT INTO product  VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/kopoctc", "root", "kopo37");
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, product.getId());
			stmt.setString(2, product.getName());
			stmt.setInt(3, product.getUnitPrice());
			stmt.setString(4, product.getDescription());
			stmt.setString(5, product.getCategory());
			stmt.setString(6, product.getManufacturer());
			stmt.setLong(7, product.getUnitsInStock());
			stmt.setString(8, product.getCondition());
			//0보다 크면 insert 됨
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new IllegalStateException("insert 실패 " + e.getMessage());
		}
	}

	@Override
	public void update(Product product) {
		// PreparedStatement 동적 쿼리, INSERT UPDATE DELETE 여러번 할 때 고속
		String sql = "UPDATE product SET p_name=?, p_unitPrice=?, p_description=?, p_category=?, p_manufacturer=?, p_unitsInStock=?, p_condition=?";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/kopoctc", "root", "kopo37");
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, product.getName());
			stmt.setInt(2, product.getUnitPrice());
			stmt.setString(3, product.getDescription());
			stmt.setString(4, product.getCategory());
			stmt.setString(5, product.getManufacturer());
			stmt.setLong(6, product.getUnitsInStock());
			stmt.setString(7, product.getCondition());
			//0보다 크면 insert 됨
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new IllegalStateException("update 실패 " + e.getMessage());
		}	
	}

	@Override
	public void delete(Product product) {
		// PreparedStatement 동적 쿼리, INSERT UPDATE DELETE 여러번 할 때 고속
		String sql = "DELETE FORM product WHERE p_id=?";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/kopoctc", "root", "kopo37");
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, product.getId());
			//0보다 크면 insert 됨
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new IllegalStateException("delete 실패 " + e.getMessage());
		}	
		
	}

}
