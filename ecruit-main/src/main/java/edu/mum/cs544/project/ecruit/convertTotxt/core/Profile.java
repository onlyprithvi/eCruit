package edu.mum.cs544.project.ecruit.convertTotxt.core;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;





@Entity
public class Profile {

	@Id
	@GeneratedValue
	int id;

	private String fullName;
	private String location;
	private String indrustry;
	
	
	@ManyToMany(cascade= CascadeType.ALL)
	private Set<Skill> skillSet;
	@ManyToMany(cascade= CascadeType.ALL)
	private Set<Education> edulvls;
	private int experience;
	@ManyToMany(cascade= CascadeType.ALL)
	private Set<Ceritficate> certificates;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Skill> getSkillSet() {
		return skillSet;
	}

	public void addSkillSet(String skill) {
		if (this.skillSet == null) {
			this.skillSet = new HashSet<Skill>();
		}
		Skill s = new Skill();
		s.setName(skill);
		this.skillSet.add(s);
	}

	public Set<Education> getEdulvls() {
		return edulvls;
	}

	public void addEdulvls(String edulvl) {
		if (this.edulvls == null)
			this.edulvls = new HashSet<Education>();
		Education e = new Education();
		e.setName(edulvl);
		this.edulvls.add(e);
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Set<Ceritficate> getCertificates() {
		return certificates;
	}

	public void addCertificates(String certificates) {
		if (this.certificates == null)
			this.certificates = new HashSet<Ceritficate>();

		Ceritficate e = new Ceritficate();
		e.setName(certificates);
		this.certificates.add(e);
		this.certificates.add(e);
	}

	public String getIndrustry() {
		return indrustry;
	}

	public void setIndrustry(String indrustry) {
		this.indrustry = indrustry;
	}

	@Override
	public String toString() {
		return "Profile:" + fullName + " || " + indrustry + " || " + location
				+ " || " + skillSet + " || " + edulvls + " || " + experience
				+ "months || " + certificates;

	}

}
