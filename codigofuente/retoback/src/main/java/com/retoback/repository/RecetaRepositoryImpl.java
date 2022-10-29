package com.retoback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retoback.model.Recetas;
@Repository
public interface RecetaRepositoryImpl extends JpaRepository<Recetas, Integer> {
	 
	}
