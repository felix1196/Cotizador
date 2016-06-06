/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cotizador;

public class Componentes {
private int idComponentes;    
private String componente;
private String categoria;
private int existentes;
private double precio;

public Componentes(String componente,String categoria,int existentes,double precio){
  this.idComponentes = idComponentes;
  this.componente = componente;
  this.categoria = categoria;
  this.existentes = existentes;
  this.precio = precio;
  
}

    public int getIdComponentes() {
        return idComponentes;
    }

    public void setIdComponentes(int idComponentes) {
        this.idComponentes = idComponentes;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getExistentes() {
        return existentes;
    }

    public void setExistentes(int existentes) {
        this.existentes = existentes;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

 



}
