package com.proofssd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proofssd.model.Leg;
import com.proofssd.repositpry.LegRepository;

@Service
public class LegService {

	@Autowired
	private LegRepository legRepository;

	public List<Leg> findAll() {
		return legRepository.findAll();
	}

	public Leg findById(Long id) {
		Optional<Leg> obj = legRepository.findById(id);
		return obj.orElse(null);
	}

	public Leg save(Leg leg) {
		return legRepository.save(leg);
	}

	public void delete(Long id) {
		legRepository.deleteById(id);
	}
}