/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.insitel.ubicaciones_crud.repository;

import com.insitel.ubicaciones_crud.entity.Ubicaciones;
import com.insitel.ubicaciones_crud.respository.CRUD.UbicacionesCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sando
 */
@Repository
public class UbicacionesRepository{
    @Autowired
    private UbicacionesCrudRepository ubicacionesCrudRepository;
    
    public List<Ubicaciones> getAll(){
        return (List<Ubicaciones>) ubicacionesCrudRepository.findAll();
    }
    
    public Optional<Ubicaciones> getUbicacion(int id){
        return ubicacionesCrudRepository.findById(id);
    }
    
    public Ubicaciones save(Ubicaciones ubicaciones){
        return ubicacionesCrudRepository.save(ubicaciones);
    }
    
    public void deleteUbicacion (int id){
        ubicacionesCrudRepository.deleteById(id);
    }
}
