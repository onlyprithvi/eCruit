package edu.mum.cs544.project.ecruit.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs544.project.ecruit.domain.Profile;
import edu.mum.cs544.project.ecruit.domain.QueryFilter;
import edu.mum.cs544.project.ecruit.domain.User;
import edu.mum.cs544.project.ecruit.domain.UserInputFilter;
import edu.mum.cs544.project.ecruit.repository.QueryFilterRepository;
import edu.mum.cs544.project.ecruit.service.ProfileService;
import edu.mum.cs544.project.ecruit.service.UserService;

@Service
// @Transactional(propagation=Propagation.REQUIRES_NEW)
public class QueryFilterService {
	public static final int INDUSTRY = 0;
	public static final int SKILL = 1;
	public static final int EDUCATION = 2;

	@Autowired
	private QueryFilterRepository queryFilterRepository;

	@Autowired
	UserService userService;
	@Autowired
	ProfileService profileService;

	public QueryFilter getQueryFilter(int queryId) {
		return queryFilterRepository.findOne(queryId);

	}

	public void addFilter(long id, QueryFilter qf) {
		User user = userService.find(id);
		user.addFilter(qf);
		userService.saveUser(user);
	}

	public void addFilter(int id, String filter, int filterType) {
		QueryFilter qf = queryFilterRepository.findOne(id);
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
		queryFilterRepository.save(qf);

	}

	public void addFilter(long userId, String industry,
			List<String> educations, List<String> skills,
			int minimumExperience, String name) {
		QueryFilter qf = new QueryFilter(industry, skills, educations,
				minimumExperience, name);
		User user = userService.find(userId);
		user.addFilter(qf);
		userService.saveUser(user);
	}

	public List<Profile> executeQueryFilter(int queryId) {
		QueryFilter qf = getQueryFilter(queryId);
		return executeQueryFilter(qf);

	}

	public List<Profile> executeQueryFilter(QueryFilter qf) {
		List<Profile> ret = new ArrayList<Profile>();
		List<Profile> profiles = profileService.getAllProfiles();
		boolean matches = true;
		for (Profile p : profiles) {
			if (qf.getEducations()!=null) {

				for (String s : qf.getEducations()) {
					if (!p.getEducation().contains(s)) {
						matches = false;
						break;
					}

				}
			}
			if (qf.getSkills()!=null) {
				for (String s : qf.getSkills()) {
					if (!p.getSkills().contains(s)) {
						matches = false;
						break;
					}

				}
			}
			if (qf.getIndustry()!=null) {
				if (!p.getIndustry().equals(qf.getIndustry())) {
					matches = false;
				}
			}

			if (qf.getMinimumExperience() != 0) {
				if (!(p.getExperience() >= qf.getMinimumExperience())) {
					matches = false;
				}
			}
			if (matches) {
				ret.add(p);
			}
			matches = true;

		}
		return ret;
	}

	public void addIndustryFilter(int queryFilterId, String industry) {
		addFilter(queryFilterId, industry, INDUSTRY);

	}

	public void addSkillFilter(int queryFilterId, String skill) {
		addFilter(queryFilterId, skill, SKILL);

	}

	public void addEducationFilter(int queryFilterId, String education) {
		addFilter(queryFilterId, education, EDUCATION);

	}

	public void setMinimumExperienceFilter(int queryFilterId, int min) {
		QueryFilter qf = queryFilterRepository.findOne(queryFilterId);
		qf.setMinimumExperience(min);
		queryFilterRepository.save(qf);
	}

	public List<QueryFilter> getAllQueryFilters(long userId) {
		return queryFilterRepository.getQueryFilters(userId);
	}

	public QueryFilter userFilterToQueryFilter(UserInputFilter filter) {
		List<String> educations = new LinkedList<String>();
		List<String> skills = new LinkedList<String>();
		QueryFilter qf = new QueryFilter();

		if (filter.getEducation().trim().isEmpty()) {
			qf.setEducations(null);

		} else {
			for (String token : filter.getEducation().split(",")) {
				educations.add(token.trim());
			}
			qf.setEducations(educations);

		}

		if (filter.getSkills().trim().isEmpty()) {
			qf.setSkills(null);
		} else {
			for (String token : filter.getSkills().split(",")) {
				skills.add(token.trim());
			}
			qf.setSkills(skills);
		}

		if (filter.getExperience().trim().isEmpty()) {
			qf.setMinimumExperience(0);
		} else
			qf.setMinimumExperience(Integer.parseInt(filter.getExperience()));
		if (filter.getIndustry().trim().isEmpty()) {
			qf.setIndustry(null);
		} else {
			qf.setIndustry(filter.getIndustry());
		}
		qf.setFilterName(filter.getName().trim().isEmpty() ? "temp" : filter.getName());
		return qf;

	}

	public List<Profile> saveUserFilter(Long id, UserInputFilter filter) {
		addFilter(id.longValue(), userFilterToQueryFilter(filter));
		return executeUserFilter(filter);
	}

	public List<Profile> executeUserFilter(UserInputFilter filter) {
		return executeQueryFilter(userFilterToQueryFilter(filter));

	}

}
