package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.AbstractDAOImpl;
import br.edu.ifpb.es.daw.dao.UserSTDAO;
import br.edu.ifpb.es.daw.entities.st.UserST;
import jakarta.persistence.EntityManagerFactory;

public class UserSTDAOImpl extends AbstractDAOImpl<UserST, Long> implements UserSTDAO {

	public UserSTDAOImpl(EntityManagerFactory emf) {
		super(UserST.class, emf);
	}

}
