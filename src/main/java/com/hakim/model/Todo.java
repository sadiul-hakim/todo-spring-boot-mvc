package com.hakim.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Todo {

	@Id
	@GeneratedValue
	private long id;
	private String content;
	private Date date;
	
	
	
	public Todo() {
		super();
	}
	public Todo(long id, String content, Date date) {
		super();
		this.id = id;
		this.content = content;
		this.date = date;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", content=" + content + ", date=" + date + "]";
	}
}
