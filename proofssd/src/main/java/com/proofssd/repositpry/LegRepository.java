package com.proofssd.repositpry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proofssd.model.Leg;

public interface LegRepository extends JpaRepository<Leg, Long> {

}
