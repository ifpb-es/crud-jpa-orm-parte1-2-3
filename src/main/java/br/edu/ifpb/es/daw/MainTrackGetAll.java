package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.TrackDAO;
import br.edu.ifpb.es.daw.dao.impl.TrackDAOImpl;
import br.edu.ifpb.es.daw.entities.Track;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainTrackGetAll {

	public static void main(String[] args) throws DawException {
		try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
			TrackDAO dao = new TrackDAOImpl(emf);
			List<Track> tracks = dao.getAll();

			for (Track track : tracks) {
				System.out.println(track);
			}
		}
	}

}
