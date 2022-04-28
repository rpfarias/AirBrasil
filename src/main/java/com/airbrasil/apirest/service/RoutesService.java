package com.airbrasil.apirest.service;

import com.airbrasil.apirest.domain.model.Routes;
import com.airbrasil.apirest.repository.RoutesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutesService {

    private final RoutesRepository routesRepository;

    public RoutesService(RoutesRepository routesRepository) {
        this.routesRepository = routesRepository;
    }

    public List<Routes> routesList() {
        return routesRepository.findAll();
    }

    public Routes create(Routes routes) {
        return routesRepository.save(routes);
    }

    public Routes update(Routes routes, Long id) {
        return routesRepository.save(routes);
    }

    public void deleteById(Long id) {
        routesRepository.deleteById(id);
    }
}
