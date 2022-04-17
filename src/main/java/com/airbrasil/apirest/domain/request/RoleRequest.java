package com.airbrasil.apirest.domain.request;

import com.airbrasil.apirest.enums.RoleName;
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

    @Enumerated(EnumType.STRING)
    private RoleName name;
}
