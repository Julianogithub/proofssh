package com.proofssd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proofssd.model.Neck;
import com.proofssd.repositpry.NeckRepository;

@Service
public class NeckService {

    @Autowired
    private NeckRepository neckRepository;

    public List<Neck> findAll() {
        return neckRepository.findAll();
    }

    public Neck findById(Long id) {
        Optional<Neck> obj = neckRepository.findById(id);
        return obj.orElse(null);
    }

    public Neck save(Neck neck) {
        return neckRepository.save(neck);
    }

    public void delete(Long id) {
        neckRepository.deleteById(id);
    }
}