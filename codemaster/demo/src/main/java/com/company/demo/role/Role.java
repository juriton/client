package com.company.demo.role;

import com.company.demo.common.AuditedEntity;
import com.company.demo.user.ApplicationUser;

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
