package org.elvis.webbappcookiematu.models;

public class Categorias {
    //Encanpsular todos los parametros de objeto
    private int idCategoria;
    private String nombre;
    private String descripcion;
    private int condicion;

    //Implementar un constructor vacio
    public Categorias(){

    }
    //Inicializamos un constructor con los parámetros del objeto
    public Categorias(int idCatgoria, String nombre, String descripcion, int condicion){
        this.idCategoria = idCatgoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.condicion = condicion;
    }
    //implementamos los método get and set


    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCondicion() {
        return condicion;
    }

    public void setCondicion(int condicion) {
        this.condicion = condicion;
    }
}
