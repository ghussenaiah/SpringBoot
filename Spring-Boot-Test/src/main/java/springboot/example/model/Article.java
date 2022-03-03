package springboot.example.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

import javax.persistence.Entity;

@Entity
@Table(name = "ARTICLE")
public class Article {

	@Id
	@GeneratedValue
	@Column(name = "ARTICLE_ID")

	private long id;
	@Column(name = "ARTICLE_TITLE")
	private String title;
	@Column(name = "ARTICLE_DESCRIPTION")
	private String description;
	@Column(name = "ARTICLE_KEYWORDS")
	private String keywords;
	@Column(name = "ARTICLE_CONTENT")
	private String content;

	public Article() {
	}

	public Article(String title, String description, String keywords, String content) {
		this.title = title;
		this.description = description;
		this.keywords = keywords;
		this.content = content;
	}

	// other getters and setters...
}
