package edu.mum.cs544.project.ecruiter.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.project.ecruiter.domain.QueryFilter;
import edu.mum.cs544.project.ecruiter.domain.Recruiter;

@Transactional(propagation = Propagation.MANDATORY)
public class RecruiterDao {
	public static final int INDUSTRY = 0;
	public static final int SKILL = 1;
	public static final int EDUCATION = 2;
	private SessionFactory sf;

	@Transactional(propagation = Propagation.SUPPORTS)
	public SessionFactory getSf() {
		return sf;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public RecruiterDao() {
	}

	public void createRecruiter(String name) {
		sf.getCurrentSession().persist(new Recruiter(name));
	}

	public Recruiter getRecruiter(int id) {
		return (Recruiter) sf.getCurrentSession().get(Recruiter.class, id);
	}

	public void deleteRecruiter(int id) {
		// TODO Auto-generated method stub
		Recruiter rec = (Recruiter) sf.getCurrentSession().load(
				Recruiter.class, id);
		sf.getCurrentSession().delete(rec);

	}

	

	

}
