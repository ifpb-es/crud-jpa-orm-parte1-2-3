package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.impl.BookDAOImpl;
import br.edu.ifpb.es.daw.dao.BookDAO;
import br.edu.ifpb.es.daw.entities.Book;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;


public class MainBookGetByID {
	
	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			BookDAO dao = new BookDAOImpl(emf);
			// Primeiro salvar
			Book book = new Book();

			book.setTitle("Java Persistence with Hibernate");
			book.setDescription("Java Persistence with Hibernate, Second Edition explores Hibernate by developing an " +
					"application that ties together hundreds of individual examples. " + System.nanoTime());
			book.setIsbn("9781617290459" + System.nanoTime());
			book.setNbOfPage(608);
			book.setPrice(300f);
			book.setIllustrations(true);
			book.setTags(List.of("java", "persistence", "orm", "jpa", "hibernate"));

			dao.save(book);

			// Depois recuperar pelo identificador
			
			Book resultado = dao.getByID(book.getId());
			
			System.out.println(book.equals(resultado));
		}
	}

}
