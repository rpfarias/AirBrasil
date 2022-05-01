package com.airbrasil.apirest.domain.request;

import com.airbrasil.apirest.enums.RoleName;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleUpdateRequest {

    @JsonValue
    @Enumerated(EnumType.STRING)
    private RoleName roleName;
}
