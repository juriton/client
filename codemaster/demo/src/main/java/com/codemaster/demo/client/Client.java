package com.codemaster.demo.client;

import com.codemaster.demo.common.AuditedEntity;
import com.codemaster.demo.country.Country;
import com.codemaster.demo.user.ApplicationUser;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Getter
@Setter
@Entity
@Table(name = "client")
public class Client extends AuditedEntity {

    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country")
    private Country country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public ApplicationUser user;
}
