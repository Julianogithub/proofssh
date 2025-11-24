package com.proofssd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proofssd.model.Thigh;
import com.proofssd.repositpry.ThighRepository;

@Service
public class ThighService {

    @Autowired
    private ThighRepository thighRepository;

    public List<Thigh> findAll() {
        return thighRepository.findAll();
    }

    public Thigh findById(Long id) {
        Optional<Thigh> obj = thighRepository.findById(id);
        return obj.orElse(null);
    }

    public Thigh save(Thigh thigh) {
        return thighRepository.save(thigh);
    }

    public void delete(Long id) {
        thighRepository.deleteById(id);
    }
}