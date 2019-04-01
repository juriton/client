package com.codemaster.demo.client;

import com.codemaster.demo.common.AuditedEntity;
import com.codemaster.demo.user.ApplicationUser;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    private String country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonProperty
    public ApplicationUser user;
}
