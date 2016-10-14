package org.penguin.study.boot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by terry on 14/10/2016.
 */

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long articleId;

	@Version
	private Integer version;

	@NotNull
	@Column(nullable = false)
	private String title;

	@NotNull
	@Column(nullable = false)
	private String content;

	private Integer prior = 0;

	@NotNull
	@Column(nullable = false)
	private Date createDate;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "authorId")
	private Person author;

	@ManyToOne
	@JoinColumn(name = "answerId")
	private Article answer;


	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPrior() {
		return prior;
	}

	public void setPrior(Integer prior) {
		this.prior = prior;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}

	public Article getAnswer() {
		return answer;
	}

	public void setAnswer(Article answer) {
		this.answer = answer;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Article article = (Article) o;

		return articleId != null ? articleId.equals(article.articleId) : article.articleId == null;

	}

	@Override
	public int hashCode() {
		return articleId != null ? articleId.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Article{" +
				"articleId=" + articleId +
				", version=" + version +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", prior=" + prior +
				", createDate=" + createDate +
				", author=" + author +
				", answer=" + answer +
				'}';
	}
}
