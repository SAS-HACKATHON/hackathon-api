package com.sofrecom.hackathon.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password = "";
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "email")
	private String email;

	@JsonIgnore
	private int securityProviderId;
	@JsonIgnore
	private int defaultCustomerId;

	@Enumerated(EnumType.STRING)
	private Role role;

	@JsonIgnore
	private boolean isActive;
	@JsonIgnore
	private boolean isBlocked;
	@JsonIgnore
	private String secretQuestion;
	@JsonIgnore
	private String secretAnswer;
	@JsonIgnore
	private boolean enableBetaTesting;
	@JsonIgnore
	private boolean enableRenewal;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	List<Commentaire> commentaires;
	

	
	public User() {
		this("new", "PASSWORD", Role.USER, "new", "new", true, "", "", true, false);
	}

	public User(String username, String password, String firstName, String lastName) {
		this(username, password, Role.USER, firstName, lastName, true, "", "", true, false);
	}

	public User(String username, String password, Role role, String firstName, String lastName) {
		this(username, password, role, firstName, lastName, true, "", "", true, false);
	}

	public User(String username, String password, Role role, String firstName, String lastName, boolean isActive) {
		this(username, password, role, firstName, lastName, isActive, "", "", true, false);
	}

	public User(String username, String password, Role role, String firstName, String lastName, boolean isActive,
			String secretQuestion, String secretAnswer, boolean enableRenewal, boolean enableBetaTesting) {
		this.setUsername(username);
		this.setPassword(new BCryptPasswordEncoder().encode(password));
		this.setRole(role);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setActive(isActive);

		this.setSecretQuestion(secretQuestion);
		this.setSecretAnswer(secretAnswer);
		this.setEnableRenewal(enableRenewal);
		this.setEnableBetaTesting(enableBetaTesting);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public String getFullName() {
		return this.firstName + this.lastName;
	}

	public Integer getUserId() {
		return id;
	}

	public void setUserId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSecurityProviderId() {
		return securityProviderId;
	}

	public void setSecurityProviderId(int securityProviderId) {
		this.securityProviderId = securityProviderId;
	}

	public int getDefaultCustomerId() {
		return defaultCustomerId;
	}

	public void setDefaultCustomerId(int defaultCustomerId) {
		this.defaultCustomerId = defaultCustomerId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	public boolean isEnableBetaTesting() {
		return enableBetaTesting;
	}

	public void setEnableBetaTesting(boolean enableBetaTesting) {
		this.enableBetaTesting = enableBetaTesting;
	}

	public boolean isEnableRenewal() {
		return enableRenewal;
	}

	public void setEnableRenewal(boolean enableRenewal) {
		this.enableRenewal = enableRenewal;
	}

	
	
	
	
	

}
