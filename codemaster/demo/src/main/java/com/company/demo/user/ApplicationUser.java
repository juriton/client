package com.company.demo.user;

import com.company.demo.common.AuditedEntity;
import com.company.demo.role.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "\"user\"")
public class ApplicationUser extends AuditedEntity {

    @Column(name = "user_name")
    private String userName;

    private String password;

    @ManyToMany
    private Set<Role> roles;
}
