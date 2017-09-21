package com.sofrecom.hackathon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.persistence.*;
import lombok.*;
import javax.validation.constraints.*;
import java.util.EnumSet;

@Entity
public class User {
	@Id
	private String userId;
	private String password = "";
	private String firstName;
	private String lastName;
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

	public User() {
		this("new", "PASSWORD", Role.USER, "new", "new", true, "", "", true, false);
	}

	public User(String userId, String password, String firstName, String lastName) {
		this(userId, password, Role.USER, firstName, lastName, true, "", "", true, false);
	}

	public User(String userId, String password, Role role, String firstName, String lastName) {
		this(userId, password, role, firstName, lastName, true, "", "", true, false);
	}

	public User(String userId, String password, Role role, String firstName, String lastName, boolean isActive) {
		this(userId, password, role, firstName, lastName, isActive, "", "", true, false);
	}

	public User(String userId, String password, Role role, String firstName, String lastName, boolean isActive,
			String secretQuestion, String secretAnswer, boolean enableRenewal, boolean enableBetaTesting) {
		this.setUserId(userId);
		this.setEmail(userId);
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

	public String getFullName() {
		return this.firstName + this.lastName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
