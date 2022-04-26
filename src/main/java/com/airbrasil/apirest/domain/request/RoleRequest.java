package com.airbrasil.apirest.domain.request;

import com.airbrasil.apirest.enums.RoleName;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequest {

    @JsonValue
    @Enumerated(EnumType.STRING)
    private RoleName name;
}
