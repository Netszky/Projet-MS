package ynov.projetms.article.model;

import java.sql.Date;
import java.util.Collection;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "articles")
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="date_article")
	@CreationTimestamp
	private Date date;
	
	@Column(name="content")
	private String content;
	
	/*@Transient
	private Collection<Comment> comments;*/
	
	@Column(name="id_category")
	private Integer id_category;
	
	@Column(name="id_user")
	private Integer id_user;

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

	public Integer getId_category() {
		return id_category;
	}

	public void setId_category(Integer id_category) {
		this.id_category = id_category;
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}
	/*public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}
	*/
}
