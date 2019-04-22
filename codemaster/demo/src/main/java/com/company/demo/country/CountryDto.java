package com.company.demo.country;

import com.company.demo.common.AuditedEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryDto extends AuditedEntity {
    private String name;
}
