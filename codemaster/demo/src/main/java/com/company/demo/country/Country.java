package com.company.demo.country;

import com.company.demo.common.AuditedEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "country")
public class Country extends AuditedEntity {

    private String name;
}
