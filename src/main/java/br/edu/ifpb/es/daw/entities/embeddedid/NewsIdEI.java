package br.edu.ifpb.es.daw.entities.embeddedid;

import jakarta.persistence.Basic;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class NewsIdEI implements Serializable {

	private static final long serialVersionUID = 7356467041303674379L;

	@Basic
	private String title;

	@Basic
	private String language;

	public NewsIdEI() {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewsIdEI other = (NewsIdEI) obj;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NewsIdEI [title=" + title + ", language=" + language + "]";
	}

}
