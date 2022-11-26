/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.insitel.ubicaciones_crud.service;

import com.insitel.ubicaciones_crud.entity.Ubicaciones;
import com.insitel.ubicaciones_crud.repository.UbicacionesRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sando
 */
@Service
public class UbicacionesService {
    @Autowired
    private UbicacionesRepository repository;
    
    public List<Ubicaciones> getAll(){
        return repository.getAll();
    }
    
    public Ubicaciones save(Ubicaciones ubicaciones){
        if(ubicaciones.getId() == null){
            return new Ubicaciones();
        }
        else{
            if(ubicaciones.getLatitud() == null || ubicaciones.getLongitud() == null ||
                    ubicaciones.getNombre_estacion() == null ){
                return new Ubicaciones();
            }
            else{
                Optional <Ubicaciones> existUbicaciones = repository.getUbicacion(ubicaciones.getId());
                if (existUbicaciones.isEmpty()){
                    return repository.save(ubicaciones);
                }
                else{
                    return new Ubicaciones();
                }
            }
        }
    }
    
    public Ubicaciones update(Ubicaciones ubicacion){
        Optional <Ubicaciones> existUbicacion = repository.getUbicacion(ubicacion.getId());
        
        if(existUbicacion.isPresent()){
            if(ubicacion.getId()!=null){
                existUbicacion.get().setId(ubicacion.getId());
            }
            if(ubicacion.getLatitud()!=null){
                existUbicacion.get().setLatitud(ubicacion.getLatitud());
            }
            if(ubicacion.getLongitud()!=null){
                existUbicacion.get().setLongitud(ubicacion.getLongitud());
            }
            if(ubicacion.getNombre_estacion()!=null){
                existUbicacion.get().setNombre_estacion(ubicacion.getNombre_estacion());
            }
            existUbicacion.get().setTemperatura(ubicacion.getTemperatura());
            return repository.save(ubicacion);
        }
        else{
            return new Ubicaciones();
        }
    }
    
    public boolean delete(int id){
        Boolean aBoolean = repository.getUbicacion(id).map(ubicacion -> {
            repository.deleteUbicacion(ubicacion.getId());
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
