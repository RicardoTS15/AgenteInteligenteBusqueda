/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Receta;

import java.util.List;

/**
 *
 * @author ric21
 */
public class Receta {
    private final List<Paso> Pasos;
    private final List<Ingrediente> Ingredientes;
    private final String id;

    public Receta(String id,List<Paso> Pasos,List<Ingrediente> Ingredientes) {
        this.Pasos = Pasos;
        this.Ingredientes = Ingredientes;
        this.id = id;
    }

    public List<Paso> getPasos() {
        return Pasos;
    }

    public List<Ingrediente> getIngredientes() {
        return Ingredientes;
    }

    public String getId() {
        return id;
    }

}
