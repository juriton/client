package com.codemaster.demo.user;

import com.codemaster.demo.common.AuditedEntity;
import com.codemaster.demo.role.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "\"user\"")
public class ApplicationUser extends AuditedEntity {

    @Column(name = "user_name")
    private String userName;

    private String password;

    @ManyToMany
    private Set<Role> roles;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
