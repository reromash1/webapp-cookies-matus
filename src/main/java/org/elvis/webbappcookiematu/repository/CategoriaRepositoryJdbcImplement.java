package org.elvis.webbappcookiematu.repository;

import org.elvis.webbappcookiematu.models.Categorias;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositoryJdbcImplement implements Repository<Categorias> {

    //obtenemos la conexión a la BBDD
    private Connection conn;

    public CategoriaRepositoryJdbcImplement(Connection conn) {
        this.conn = conn;
    }


    @Override
    public List<Categorias> listar() throws SQLException {
        List<Categorias> categorias = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from categorias")) {

            while(rs.next()){
                Categorias cate = new Categorias();
                cate.setIdCategoria(rs.getInt("idcategoria"));
                cate.setNombre(rs.getString("nombre"));
                cate.setDescripcion(rs.getString("descripcion"));
                cate.setCondicion(rs.getInt("condicion"));
                categorias.add(cate);
            }

        }
        return categorias;
    }

    @Override
    public Categorias porId(int id) throws SQLException {
        return null;
    }

    @Override
    public void guardar(Categorias categorias) throws SQLException {

    }

    @Override
    public void eliminar(int id) throws SQLException {

    }
}
