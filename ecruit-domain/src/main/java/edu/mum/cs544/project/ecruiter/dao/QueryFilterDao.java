package edu.mum.cs544.project.ecruiter.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import edu.mum.cs544.project.ecruiter.domain.QueryFilter;

public class QueryFilterDao {
	SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public QueryFilterDao() {
	}

	public void createQueryFilter(List<String> industries, List<String> skills,
			List<String> educations, int minimumExperience)

	{
		QueryFilter qf = new QueryFilter(industries, skills, educations,
				minimumExperience);
		sf.getCurrentSession().persist(qf);
	}

	public QueryFilter getQueryFilter(int id) {

		return (QueryFilter) sf.getCurrentSession().get(QueryFilter.class, id);
	}

	public void deleteQueryFilter(int id) {
		QueryFilter qf = (QueryFilter) sf.getCurrentSession().load(
				QueryFilter.class, id);
		sf.getCurrentSession().delete(qf);
	}
}
