package com.retoback.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retoback.model.Ingredientes;
import com.retoback.model.Recetas;
import com.retoback.repository.RecetaRepository;
import com.retoback.repository.RecetaRepositoryImpl;
import com.retoback.request.recetaRequest;
import com.retoback.service.RecetaService;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/receta")
public class RecetaController {
	
	//@Autowired
	//private RecetaService usuarioRepository;

	 @Autowired
    private RecetaRepository service;
	
	 private RecetaService usuarioRepository;
	 
	@PostMapping("/query")
	public recetaRequest listarRecetasPorIngredientes(@RequestBody Ingredientes ingredientes){
		System.out.println("ingredientes:"+ingredientes.toString());
		return usuarioRepository.listarRecetasPorIngredientes(ingredientes);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Recetas> guardarReceta(@RequestBody Recetas recetas){
		System.out.println("receta:"+recetas.toString());
		
		try {
	        Recetas oReceta =  service.save(recetas);
	        return new ResponseEntity<Recetas>(oReceta, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Recetas>(HttpStatus.NOT_FOUND);
	    } 
	}
	
	@GetMapping("/recetas")
	public List<Recetas> list() {
	    return service.listAll();
	}

}