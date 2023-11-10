package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.TodoDetails;

public class TodoDAO {
	private Connection connection;

	public TodoDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	// Insert data into the Database
	public boolean addTodo(String name, String todo, String status) {
		boolean f = false;
		try {
			
			String sql = "INSERT INTO todo_app (name, todo, status) VALUES(?, ?, ?)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, todo);
			ps.setString(3, status);
			
			int i = ps.executeUpdate();
			if (i == 1) {
				f= true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	//Fetch the data from the database
	public List<TodoDetails> getTodo(){
		List<TodoDetails> list = new ArrayList<TodoDetails>();
		TodoDetails t = null;
		
		try {
			String sql = "SELECT * FROM todo_app";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				t = new TodoDetails();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setTodo(rs.getString(3));
				t.setSatus(rs.getString(4));
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//Fetch the data from the database through ID
	public TodoDetails getTodoById(int id) {
		TodoDetails t = null;
		try {
			String sql = "SELECT * FROM todo_app where id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				t= new TodoDetails();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setTodo(rs.getString(3));
				t.setSatus(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	
	
	//Update the data
	public boolean updateTodo(TodoDetails t) {
		boolean f = false;
		try {
			String sql = "UPDATE todo_app set name = ?, todo = ?, status = ? where id = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, t.getName());
			ps.setString(2, t.getTodo());
			ps.setString(3, t.getSatus());
			ps.setInt(4, t.getId());
			
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	//Delete data from the database
	public boolean deleteTodo(int id) {
		boolean f = false;
		
		try {
			String sql = "DELETE FROM todo_app WHERE id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
}
