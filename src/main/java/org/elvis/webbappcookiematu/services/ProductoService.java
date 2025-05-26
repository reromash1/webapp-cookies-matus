package org.elvis.webbappcookiematu.services;

import org.elvis.webbappcookiematu.models.Productos;

import java.util.List;

public interface ProductoService {
    //Implementamos un método para listar los productos
    List<Productos> listar();
}
