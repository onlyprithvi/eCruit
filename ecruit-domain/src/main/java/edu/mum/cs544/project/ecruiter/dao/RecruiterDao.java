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

	public void addFilter(int recruiterId, String industry,
			List<String> educations, List<String> skills, int minimumExperience,String name) {
		Recruiter rec = (Recruiter) sf.getCurrentSession().load(
				Recruiter.class, recruiterId);
		QueryFilter qf = new QueryFilter(industry, skills, educations,
				minimumExperience,name);
		rec.addFilter(qf);
		sf.getCurrentSession().update(rec);

	}

	public void addFilter(int recruiterId, int queryFilterId, String filter,
			int filterType) {
		// TODO Auto-generated method stub
		Query query = sf
				.getCurrentSession()
				.createQuery(
						"SELECT DISTINCT filters FROM Recruiter r JOIN r.filters filters WHERE filters.id=:fId AND r.id=:rId");
		query.setParameter(":fId", queryFilterId);
		query.setParameter(":rId", recruiterId);
		QueryFilter qf = (QueryFilter) query.uniqueResult();
		switch (filterType) {
		case INDUSTRY:
			qf.setIndustry(filter);
			break;
		case SKILL:
			qf.addSkill(filter);
			break;
		case EDUCATION:
			qf.addEducation(filter);
			break;
		
		}
		
		sf.getCurrentSession().update(qf);

	}

	

	public void setMinimumExperience(int recruiterId, int queryFilterId, int minimumExperience) {
		// TODO Auto-generated method stub
		Query query = sf.getCurrentSession().createQuery("SELECT DISTINCT filters FROM Recruiter r JOIN r.filters filters WHERE filters.id=:fId AND r.id=:rId");
		query.setParameter(":fId", queryFilterId);
		query.setParameter(":rId", recruiterId);
		QueryFilter qf=(QueryFilter)query.uniqueResult();
		qf.setMinimumExperience(minimumExperience);
		
	}

	

}
