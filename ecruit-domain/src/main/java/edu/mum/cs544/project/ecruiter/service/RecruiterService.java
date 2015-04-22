package edu.mum.cs544.project.ecruiter.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.project.ecruiter.dao.RecruiterDao;
import edu.mum.cs544.project.ecruiter.domain.Recruiter;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public class RecruiterService {
	RecruiterDao recruiterDao;

	public RecruiterService() {
		super();
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public RecruiterDao getRecruiterDao() {
		return recruiterDao;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void setRecruiterDao(RecruiterDao recruiterDao) {
		this.recruiterDao = recruiterDao;
	}

	// public QueryFilterDao getQueryFilterDao() {
	// return queryFilterDao;
	// }

	// public void setQueryFilterDao(QueryFilterDao queryFilterDao) {
	// this.queryFilterDao = queryFilterDao;
	// }

	public void createRecruiter(String name) {
		recruiterDao.createRecruiter(name);
	}

	public Recruiter getRecruiter(int id) {
		return recruiterDao.getRecruiter(id);

	}

	public void deleteRecruiter(int id) {
		recruiterDao.deleteRecruiter(id);

	}

	public void addFilter(int recruiterId, String industry,
			List<String> educations, List<String> skills, int minimumExperience,String name) {
		recruiterDao.addFilter(recruiterId, industry, educations, skills,
				minimumExperience,name);
	}

	public void addIndustryFilter(int recruiterId, int queryFilterId,
			String industry) {
		recruiterDao.addFilter(recruiterId, queryFilterId, industry,RecruiterDao.INDUSTRY);

	}
	public void addSkillFilter(int recruiterId, int queryFilterId,
			String skill) {
		recruiterDao.addFilter(recruiterId, queryFilterId, skill,RecruiterDao.SKILL);
		
	}
	public void addEducationFilter(int recruiterId, int queryFilterId,
			String education) {
		recruiterDao.addFilter(recruiterId, queryFilterId, education,RecruiterDao.EDUCATION);
		
	}
	public void setMinimumExperienceFilter(int recruiterId, int queryFilterId,int i){
		recruiterDao.setMinimumExperience(recruiterId,queryFilterId,i);
	}

}
