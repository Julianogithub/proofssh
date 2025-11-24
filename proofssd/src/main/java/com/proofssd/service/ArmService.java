package com.proofssd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proofssd.model.Arm;
import com.proofssd.repositpry.ArmRepository;

@Service
public class ArmService {

	@Autowired
	private ArmRepository armRepository;

	public List<Arm> findAll() {
		return armRepository.findAll();
	}

	public Arm findById(Long id) {
		Optional<Arm> obj = armRepository.findById(id);
		return obj.orElse(null);
	}

	public Arm save(Arm arm) {
		return armRepository.save(arm);
	}

	public void delete(Long id) {
		armRepository.deleteById(id);
	}
}