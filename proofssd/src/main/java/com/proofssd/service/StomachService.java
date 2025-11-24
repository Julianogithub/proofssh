package com.proofssd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proofssd.model.Stomach;
import com.proofssd.repositpry.StomachRepository;

@Service
public class StomachService {

    @Autowired
    private StomachRepository stomachRepository;

    public List<Stomach> findAll() {
        return stomachRepository.findAll();
    }

    public Stomach findById(Long id) {
        Optional<Stomach> obj = stomachRepository.findById(id);
        return obj.orElse(null);
    }

    public Stomach save(Stomach stomach) {
        return stomachRepository.save(stomach);
    }

    public void delete(Long id) {
        stomachRepository.deleteById(id);
    }
}