package com.github.pablocloud.iataapi.services;

import com.github.pablocloud.iataapi.domain.Iata;
import com.github.pablocloud.iataapi.repositories.IataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IataService {

    private final IataRepository iataRepository;

    public IataService(IataRepository iataRepository) {
        this.iataRepository = iataRepository;
    }

    public List<Iata> all() {
        return iataRepository.findAll();
    }

    public Iata oneById(Long id) {
        return iataRepository.findOne(id);
    }

    public List<Iata> byName(String name) {
        return iataRepository.findAllByNameContainingIgnoreCase(name);
    }

    public List<Iata> byCode(String code) {
        return iataRepository.findAllByCodeContainingIgnoreCase(code);
    }

}
