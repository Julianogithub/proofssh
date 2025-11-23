package com.proofssd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proofssd.model.Chest;
import com.proofssd.repositpry.ChestRepository;

@Service
public class ChestService {

    @Autowired
    private ChestRepository chestRepository;

    public List<Chest> findAll() {
        return chestRepository.findAll();
    }

    public Chest findById(Long id) {
        Optional<Chest> obj = chestRepository.findById(id);
        return obj.orElse(null);
    }

    public Chest save(Chest chest) {
        return chestRepository.save(chest);
    }

    public void delete(Long id) {
        chestRepository.deleteById(id);
    }
}