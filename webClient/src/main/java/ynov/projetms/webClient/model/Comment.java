package ynov.projetms.webClient.model;

import java.sql.Date;

public class Comment {
	private Integer id;
	
	private Integer on_article_id;
	
	private Integer user_id;
	
	private Date post_date;
	
	private String content;
	
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

	public Integer getOn_article_id() {
		return on_article_id;
	}

	public void setOn_article_id(Integer on_article_id) {
		this.on_article_id = on_article_id;
	}
	
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Date getPost_date() {
		return post_date;
	}

	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
