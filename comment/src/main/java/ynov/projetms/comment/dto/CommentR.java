package ynov.projetms.comment.dto;

import java.util.Date;

import ynov.projetms.comment.model.User;

public class CommentR {
	private Integer id;
	
	private Date post_date;
	
	private String content;
	
	private Integer on_article_id;
	
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getOn_article_id() {
		return on_article_id;
	}

	public void setOn_article_id(Integer on_article_id) {
		this.on_article_id = on_article_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
