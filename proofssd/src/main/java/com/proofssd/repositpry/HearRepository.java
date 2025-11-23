package com.proofssd.repositpry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proofssd.model.Head;

public interface HearRepository extends JpaRepository<Head, Long> {

}