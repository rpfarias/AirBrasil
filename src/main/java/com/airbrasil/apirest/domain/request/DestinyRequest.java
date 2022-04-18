package com.airbrasil.apirest.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DestinyRequest {

    @Column(name = "destinos", nullable = false, unique = true, length = 50)
    @Size(min = 3, max = 50)
    private String name;
}
