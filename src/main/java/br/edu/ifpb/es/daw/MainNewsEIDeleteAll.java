package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.NewsEIDAO;
import br.edu.ifpb.es.daw.dao.impl.NewsEIDAOImpl;
import br.edu.ifpb.es.daw.entities.embeddedid.NewsEI;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainNewsEIDeleteAll {

	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			NewsEIDAO dao = new NewsEIDAOImpl(emf);
			List<NewsEI> newsEIs = dao.getAll();
			for (NewsEI newsEI : newsEIs) {
				dao.delete(newsEI.getId());
			}
		}
	}
	
}
