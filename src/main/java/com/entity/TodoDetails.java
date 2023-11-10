package com.entity;

public class TodoDetails {
	private int id;
	private String name;
	private String todo;
	private String satus;
	
	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + ", todo=" + todo + ", satus=" + satus + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public String getSatus() {
		return satus;
	}
	public void setSatus(String satus) {
		this.satus = satus;
	}
	
	
}
