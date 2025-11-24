package com.proofssd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proofssd.model.Hip;
import com.proofssd.repositpry.HipRepository;

@Service
public class HipService {

    @Autowired
    private HipRepository hipRepository;

    public List<Hip> findAll() {
        return hipRepository.findAll();
    }

    public Hip findById(Long id) {
        Optional<Hip> obj = hipRepository.findById(id);
        return obj.orElse(null);
    }

    public Hip save(Hip hip) {
        return hipRepository.save(hip);
    }

    public void delete(Long id) {
        hipRepository.deleteById(id);
    }
}