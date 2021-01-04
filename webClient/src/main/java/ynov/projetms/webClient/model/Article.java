package ynov.projetms.webClient.model;

import java.sql.Date;

public class Article {
	
	private Integer id;
	
	private Date date;
	
	private String content;
	
	private Integer id_category;
	
	private User user;
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCategory() {
		return id_category;
	}

	public void setCategory(Integer id_category) {
		this.id_category = id_category;
	}	
	
}
