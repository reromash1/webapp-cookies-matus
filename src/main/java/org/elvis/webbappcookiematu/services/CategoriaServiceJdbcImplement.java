package org.elvis.webbappcookiematu.services;

import org.elvis.webbappcookiematu.models.Categoria;
import org.elvis.webbappcookiematu.repository.CategoriaRepositoryJdbcImplemt;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CategoriaServiceJdbcImplement implements CategoriaService{

    private CategoriaRepositoryJdbcImplemt repositoryJdbc;

    //Implementamso el constructor para obtener la conexion y los métodos del CRUD
    public CategoriaServiceJdbcImplement(Connection conn){
        this.repositoryJdbc=new CategoriaRepositoryJdbcImplemt(conn);

    }

    @Override
    public List<Categoria> listar() {
        try{
            return repositoryJdbc.listar();
        }catch (SQLException throwables){
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Categoria> porId(Long id) {
        try{
            return Optional.ofNullable(repositoryJdbc.porId(id));
        }catch (SQLException throwables){
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}
