package com.zerocinco.planteUmaArvore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zerocinco.planteUmaArvore.model.PlanteUmaArvore;

@Repository
public interface TemaRepository extends JpaRepository<PlanteUmaArvore, Long> {
	
	
	public List<PlanteUmaArvore> findAllByTemaContainingIgnoreCase (String tema);

}
