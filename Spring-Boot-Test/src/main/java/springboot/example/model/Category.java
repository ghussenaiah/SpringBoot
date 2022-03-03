package springboot.example.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.ForeignKey;
 
@Entity
@Table(name = "CATEGORY", uniqueConstraints = {@UniqueConstraint(columnNames = {"CATEGORY_NAME", "CATEGORY_TYPE"})})
public class Category {

	@Id
	@GeneratedValue
	@Column(name = "CATEGORY_ID")
	private long id;


	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CATEGORY_ARTICLE", joinColumns = @JoinColumn(name = "CATEGORY_ID", foreignKey = @ForeignKey(name = "fk_movie")),
	inverseJoinColumns = @JoinColumn(name = "ARTICLE_ID", foreignKey = @ForeignKey(name = "fk_actor")))

	private Set<Article> articles;
	

	@Column(name = "CATEGORY_NAME")
	private String name;
	
	@Column(name = "CATEGORY_TYPE")
	private String type;

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}
 
}

