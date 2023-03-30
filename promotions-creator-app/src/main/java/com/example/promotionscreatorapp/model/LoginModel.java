package com.example.promotionscreatorapp.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class LoginModel {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	Integer id;
	
	String username;
	String password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		return Objects.hash(username, id, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginModel other = (LoginModel) obj;
		return Objects.equals(username, other.username) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password);
	}
	@Override
	public String toString() {
		return "LoginModel [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
}
