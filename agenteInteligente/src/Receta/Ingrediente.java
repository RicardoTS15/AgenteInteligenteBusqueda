/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Receta;

/**
 *
 * @author ric21
 */
public class Ingrediente {
    private String Cantidad;

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getUnidades() {
        return Unidades;
    }

    public void setUnidades(String Unidades) {
        this.Unidades = Unidades;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Ingrediente() {
    }
    private String Unidades;
    private String id;
    
}
