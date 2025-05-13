package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.BookDAO;
import jakarta.persistence.EntityManagerFactory;
import br.edu.ifpb.es.daw.entities.Book;

public class BookDAOImpl extends AbstractDAOImpl<Book, Long> implements BookDAO {

	public BookDAOImpl(EntityManagerFactory emf) {
		super(Book.class, emf);
	}

}
