package com.bpr.route.Users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @NotNull
  private String username;

  @NotNull
  private String password;

  @NotNull
  private boolean enabled;

  @OneToMany
  @JoinColumn(name="id_user", referencedColumnName="id")
  private List<UserRoles> userRoles;

  @NotNull
  private String token_prefix;

  public User() { }

  public User(String username, String password,
        boolean enabled, List<UserRoles> userRoles) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRoles = userRoles;
    }

  public long getId() {
      return id;
  }

  public void setId(long value) {
      this.id = value;
  }

  public String getUsername() {
      return username;
  }

  public void setUsername(String value) {
      this.username = value;
  }

  public String getPassword() {
      return password;
  }

  public void setPassword(String value) {
      this.password = value;
  }

  public boolean getEnabled() {
      return enabled;
  }

  public void setEnabled(boolean value) {
      this.enabled = value;
  }

  public List getUserRoles() {
      return userRoles;
  }

  public void setUserRoles(List<UserRoles> value) {
      this.userRoles = value;
  }

  public String getToken_prefix() {
      return token_prefix;
  }

  public void setToken_prefix(String value) {
      this.token_prefix = value;
  }
  
}