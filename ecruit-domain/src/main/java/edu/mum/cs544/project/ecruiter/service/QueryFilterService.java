package edu.mum.cs544.project.ecruiter.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.project.ecruiter.dao.QueryFilterDao;
import edu.mum.cs544.project.ecruiter.domain.Profile;
import edu.mum.cs544.project.ecruiter.domain.QueryFilter;


@Transactional(propagation=Propagation.REQUIRES_NEW)
public class QueryFilterService {
	private SessionFactory sf;
	private QueryFilterDao queryFilterDao;
	
	
	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	public QueryFilterDao getQueryFilterDao() {
		return queryFilterDao;
	}

	public void setQueryFilterDao(QueryFilterDao queryFilterDao) {
		this.queryFilterDao = queryFilterDao;
	}

	private void constraintFiller(List<String> constraints,String discriminator,Query q){
		int counter=0;
		for(String st:constraints){
			q.setParameter(discriminator+counter, st);
			counter++;
		}
	}

	private String constraintGenerator(int constraintSize, String type,String discriminator){
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<constraintSize;i++){
			sb.append(type +" = :"+discriminator+i+" AND ");
		}
		sb.replace(sb.length()-5, sb.length(), "");
		return sb.toString();
		
	}
	
	public QueryFilter getQueryFilter(int recId,int queryId){
		return queryFilterDao.getQueryFilter(queryId);
		
	}
	
	public List<Profile> executeQueryFilter(int recruiterId, int queryId) {
		QueryFilter qf=getQueryFilter(recruiterId, queryId);
		
		String queryString="SELECT p FROM Profile p JOIN p.skills s JOIN p.education e"
//				+ " WHERE "+constraintGenerator(qf.getEducations().size(), "e", "edu")
				+" WHERE p.industry = :industry "
				+ "AND e in (:educations) "
				+ "AND s in (:skills) "
//				+ " AND "+constraintGenerator(qf.getSkills().size(), "s", "ski")
				+ " AND p.experience >= :cMinExperience";
		Query q= sf.getCurrentSession().createQuery(queryString);
		q.setParameter("industry", qf.getIndustry());
//		constraintFiller(qf.getEducations(), "edu", q);
//		constraintFiller(qf.getSkills(), "ski", q);
		q.setParameterList("educations", qf.getEducations());
		q.setParameterList("skills", qf.getSkills());
		q.setParameter("cMinExperience", qf.getMinimumExperience());

		List<Profile> profiles=q.list();
		return profiles;
		

	}
	
	public void addFilter(int id, QueryFilter qf){
		queryFilterDao.addFilter(id, qf);
	}
	
	public void addFilter(int recruiterId, String industry,
			List<String> educations, List<String> skills, int minimumExperience,String name) {
		queryFilterDao.addFilter(recruiterId, industry, educations, skills,
				minimumExperience,name);
	}

	public void addIndustryFilter(int recruiterId, int queryFilterId,
			String industry) {
		queryFilterDao.addFilter(recruiterId, queryFilterId, industry,QueryFilterDao.INDUSTRY);

	}
	public void addSkillFilter(int recruiterId, int queryFilterId,
			String skill) {
		queryFilterDao.addFilter(recruiterId, queryFilterId, skill,queryFilterDao.SKILL);
		
	}
	public void addEducationFilter(int recruiterId, int queryFilterId,
			String education) {
		queryFilterDao.addFilter(recruiterId, queryFilterId, education,queryFilterDao.EDUCATION);
		
	}
	public void setMinimumExperienceFilter(int recruiterId, int queryFilterId,int i){
		queryFilterDao.setMinimumExperience(recruiterId,queryFilterId,i);
	}
	
	public List<QueryFilter> getAllQueryFilters(int id){
		return queryFilterDao.getAllFilters(id);
	}

}
