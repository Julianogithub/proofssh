package com.proofssd.repositpry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proofssd.model.Chest;

public interface ChestRepository extends JpaRepository<Chest, Long> {

}
