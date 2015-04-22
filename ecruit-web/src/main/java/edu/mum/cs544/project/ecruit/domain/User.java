package edu.mum.cs544.project.ecruit.domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "USER")
public class User implements UserDetails, CredentialsContainer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private static final String defaultPicLocation = "/resource/images/user.png";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Pattern(regexp = "[A-Za-z0-9_.]{3,10}", message = "Username must be between 6 to 10 character long and only contains alphabets, numbers, underscore and dot")
	@Column(unique = true, nullable = false, name = "USERNAME")
	private String username;

	@Column(name = "LOGINPASSWORD", nullable = false)
	private String loginPassword;

	@Column(name = "FIRSTNAME", nullable = false)
	@Size(min = 2, max = 40)
	private String firstName;

	@Column(name = "LASTNAME", nullable = false)
	@Size(min = 2, max = 100)
	private String lastName;

	@Column(name = "GENDER", nullable = false, length = 1)
	private Character gender;

	@Column(name = "CONTACT_NUMBER")
	@Pattern(regexp = "[0-9]{10}", message = "Invalid Contact Number")
	private String contactNumber;

	@Column(name = "STATUS", nullable = false, length = 1)
	private UserStatus status;

	@Column(unique = true, nullable = false, name = "EMAIL")
	@Email
	private String email;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "LASTLOGINDATE")
	private Date lastLoginDate;

	@Column(name = "PICLOCATION")
	private String picLocation;

	@Column(name = "ROLE", nullable = false)
	private Role role;

	@Transient
	private String confirmLoginPassword;

	@Transient
	private String oldLoginPassword;

	@Transient
	private MultipartFile profilePic;	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String toString() {
		return getFirstName() + " " + getLastName();
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getConfirmLoginPassword() {
		return confirmLoginPassword;
	}

	public void setConfirmLoginPassword(String confirmLoginPassword) {
		this.confirmLoginPassword = confirmLoginPassword;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getOldLoginPassword() {
		return oldLoginPassword;
	}

	public void setOldLoginPassword(String oldLoginPassword) {
		this.oldLoginPassword = oldLoginPassword;
	}

	public String getPicLocation() {		
		return picLocation;
	}

	public void setPicLocation(String picLocation) {
		this.picLocation = picLocation;
	}

	public MultipartFile getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(MultipartFile profilePic) {
		this.profilePic = profilePic;
	}



	@Transient
	private Collection<GrantedAuthority> authorities;

	// ~ Methods for spring-security
	// ========================================================================================================

	public void eraseCredentials() {
		this.loginPassword = null;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public String getPassword() {
		return getLoginPassword();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return getStatus() == UserStatus.Active;
	}

}
