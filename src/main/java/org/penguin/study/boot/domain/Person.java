package org.penguin.study.boot.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by terry on 14/10/2016.
 */

@Entity
public class Person implements Serializable{

	private static final long serialVersionUID = -1410880337594497908L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long personId;

	@NotNull
	@Column(nullable = false, length = 20)
	@Length(max = 20, min = 2)
	private String fullName;

	//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "author")
//	private List<Article> articles;

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Person person = (Person) o;

		return personId != null ? personId.equals(person.personId) : person.personId == null;

	}

	@Override
	public int hashCode() {
		return personId != null ? personId.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Person{" +
				"personId=" + personId +
				", fullName='" + fullName + '\'' +
				'}';
	}
}
