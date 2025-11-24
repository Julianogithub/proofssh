package com.proofssd.repositpry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proofssd.model.Stomach;

public interface StomachRepository extends JpaRepository<Stomach, Long> {

}
