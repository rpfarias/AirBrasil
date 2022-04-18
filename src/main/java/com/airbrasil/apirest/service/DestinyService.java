package com.airbrasil.apirest.service;

import com.airbrasil.apirest.domain.model.Destiny;
import com.airbrasil.apirest.domain.request.DestinyRequest;
import com.airbrasil.apirest.repository.DestinyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class DestinyService {

    private final DestinyRepository destinyRepository;

    public DestinyService(DestinyRepository destinyRepository) {
        this.destinyRepository = destinyRepository;
    }

    public List<Destiny> findAll() {
        return destinyRepository.findAll();
    }

    public Optional<Destiny> findById(@PathVariable(value = "id") long id) {
        return destinyRepository.findById(id);
    }

    public Destiny create(@RequestBody @Valid DestinyRequest request) {

        Destiny destiny = new Destiny();
        destiny.setName(request.getName());

        return destinyRepository.save(destiny);
    }

    public Destiny update(@RequestBody @Valid Destiny destiny) {
        return destinyRepository.save(destiny);
    }

    public void delete(@PathVariable Long id) {
        destinyRepository.deleteById(id);
    }
}
