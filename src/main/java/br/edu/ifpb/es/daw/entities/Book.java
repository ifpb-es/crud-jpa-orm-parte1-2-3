package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "BOOKS",
		uniqueConstraints = {
			@UniqueConstraint(name = "UC_LIVRO", columnNames = { "TITLE", "DESCRIPTION" }),
			@UniqueConstraint(name = "UC_BOOK__ISBN", columnNames = { "ISBN" })
		},
		indexes = { @Index(name = "IX_BOOKS__ISBN", columnList = "isbn") }
)
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@GeneratedValue(generator = "jpa_books_seq")
	//@SequenceGenerator(name = "jpa_books_seq", sequenceName = "books_id_seq")
	private Long id;

	private String title;

	private Float price;

	private String description;

	private String isbn;

	@Column(name = "NB_OF_PAGE")
	private Integer nbOfPage;

	private Boolean illustrations;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "TAGS",
			joinColumns = { @JoinColumn(name = "BOOKS_ID")},
			foreignKey = @ForeignKey(name = "FK_TAGS__BOOKS_ID"),
			indexes = { @Index(name = "IX_TAGS_VALUE", columnList = "VALUE") })
	@Column(name = "VALUE")
	private List<String> tags;

	public Book() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getNbOfPage() {
		return nbOfPage;
	}

	public void setNbOfPage(Integer nbOfPage) {
		this.nbOfPage = nbOfPage;
	}

	public Boolean getIllustrations() {
		return illustrations;
	}

	public void setIllustrations(Boolean illustrations) {
		this.illustrations = illustrations;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Book)) return false;
		Book book = (Book) o;
		return Objects.equals(isbn, book.isbn);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(isbn);
	}

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", title='" + title + '\'' +
				", price=" + price +
				", description='" + description + '\'' +
				", isbn='" + isbn + '\'' +
				", nbOfPage=" + nbOfPage +
				", illustrations=" + illustrations +
				", tags=" + tags +
				'}';
	}

}
