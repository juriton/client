package com.codemaster.demo.role;

import com.codemaster.demo.common.AuditedEntity;
import com.codemaster.demo.user.ApplicationUser;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends AuditedEntity {

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<ApplicationUser> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ApplicationUser> getUsers() {
        return users;
    }

    public void setUsers(Set<ApplicationUser> users) {
        this.users = users;
    }
}
