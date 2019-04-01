package com.codemaster.demo.country;

import com.codemaster.demo.common.AuditedEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryDto extends AuditedEntity {
    private String name;
}
