/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.insitel.ubicaciones_crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.awt.Point;
import java.io.Serializable;


/**
 *
 * @author sando
 */
@Entity
@Table(name="ubicaciones")
public class Ubicaciones implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String nombre_estacion;
    private String longitud;
    private String latitud;
    private float temperatura;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_estacion() {
        return nombre_estacion;
    }

    public void setNombre_estacion(String nombre_estacion) {
        this.nombre_estacion = nombre_estacion;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }
    
    
    
}
