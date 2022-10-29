package com.retoback.repository;

import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.retoback.model.Recetas;

@Service
@Transactional
public class RecetaRepository {
	
    @Autowired
    private RecetaRepositoryImpl receta;
    

    public List<Recetas> listAll() {
        return receta.findAll();
    }
     
    public Recetas save(Recetas recetas) {
    	receta.save(recetas);
    	return recetas;
    }
     
    public Recetas get(Integer id) {
        return receta.findById(id).get();
    }
     
    public void delete(Integer id) {
    	receta.deleteById(id);
    }

}
