package org.elvis.webbappcookiematu.repository;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T>{

    //Implemtemos los métodos para el crud a la base de datos
    List<T> listar() throws SQLException;
    //Implementamos el método por id
    T porId(int id)throws SQLException;
    //implementamos un método para guardar
    void guardar(T t) throws SQLException;
    //implementamos el método eliminar
    void eliminar(int id) throws SQLException;
}
