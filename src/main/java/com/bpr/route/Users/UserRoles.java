package com.bpr.route.Users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user_roles")
public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name="id_user", nullable=false)
    private User id_user;

    @NotNull
    private String roles;

    public UserRoles() {}

    public UserRoles(User user, String roles) {
        this.id_user = user;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

    public User getId_user() {
        return id_user;
    }

    public void setId_user(User value) {
        this.id_user = value;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String value) {
        this.roles = value;
    }
}