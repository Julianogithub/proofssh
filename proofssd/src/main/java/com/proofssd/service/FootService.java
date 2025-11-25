package com.proofssd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proofssd.model.Foot;
import com.proofssd.repositpry.FootRepository;

@Service
public class FootService {

	@Autowired
	private FootRepository footRepository;

	public List<Foot> findAll() {
		return footRepository.findAll();
	}

	public Foot findById(Long id) {
		Optional<Foot> obj = footRepository.findById(id);
		return obj.orElse(null);
	}

	public Foot save(Foot foot) {
		return footRepository.save(foot);
	}

	public void delete(Long id) {
		footRepository.deleteById(id);
	}
}