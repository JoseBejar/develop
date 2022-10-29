package com.retoback.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retoback.model.Ingredientes;
import com.retoback.model.Recetas;
import com.retoback.repository.RecetaRepositoryImpl;
import com.retoback.request.recetaRequest;


public interface RecetaService {

	recetaRequest listarRecetasPorIngredientes(Ingredientes ingredientes);
	
}
