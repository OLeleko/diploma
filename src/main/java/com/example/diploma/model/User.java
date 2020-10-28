package com.example.diploma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "user_name")})
public class User extends AbstractNamedEntity{

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    private String password;

    @Column(name  = "registered", nullable = false)
    @NotNull
    private LocalDateTime registered;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled = true;

    @Column(name = "admin", nullable = false, columnDefinition = "bool default false")
    private boolean admin = false;

    public User() {
    }

    public User(User u){
        this(u.getId(), u.getName(), u.getPassword(), u.getRegistered(), u.isEnabled(), u.isAdmin());
    }

    public User(String name, @NotBlank @Size(min = 5, max = 100) String password, @NotNull LocalDateTime registered, boolean enabled, boolean admin) {
        this(null, name, password, registered, enabled, admin);
    }

    public User(Integer id, String name, @NotBlank @Size(min = 5, max = 100) String password, @NotNull LocalDateTime registered, boolean enabled, boolean admin) {
        super(id, name);
        this.password = password;
        this.registered = registered;
        this.enabled = enabled;
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", registered=" + registered +
                ", enabled=" + enabled +
                ", admin=" + admin +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
