package com.proofssd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proofssd.model.Head;
import com.proofssd.repositpry.HearRepository;

@Service
public class HeadService {

	@Autowired
	private HearRepository headRepository;

	public List<Head> findAll() {
		return headRepository.findAll();
	}

	public Head findById(Long id) {
		Optional<Head> obj = headRepository.findById(id);
		return obj.orElse(null);
	}

	public Head save(Head head) {
		return headRepository.save(head);
	}

	public void delete(Long id) {
		headRepository.deleteById(id);
	}
}