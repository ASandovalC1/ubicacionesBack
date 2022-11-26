/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.insitel.ubicaciones_crud.controller;

import com.insitel.ubicaciones_crud.entity.Ubicaciones;
import com.insitel.ubicaciones_crud.service.UbicacionesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sando
 */
@RestController
@RequestMapping("/api/Ubicaciones")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UbicacionesController {
    @Autowired
    private UbicacionesService service;
    
    
    @GetMapping("/all")
    public List<Ubicaciones> getUbicaciones(){
        return service.getAll();
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Ubicaciones save(@RequestBody Ubicaciones ubicacion){
        return service.save(ubicacion);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Ubicaciones update(@RequestBody Ubicaciones ubicacion){
        return service.update(ubicacion);
    }
    
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return service.delete(id);
    }
    
    
}
