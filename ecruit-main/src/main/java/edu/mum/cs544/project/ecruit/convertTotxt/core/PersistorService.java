package edu.mum.cs544.project.ecruit.convertTotxt.core;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PersistorService {

	SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	

	public void save(Profile p) {
	sf.getCurrentSession().save(p);
	}
	
}
