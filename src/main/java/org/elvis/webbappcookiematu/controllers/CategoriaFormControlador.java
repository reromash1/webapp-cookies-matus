package org.elvis.webbappcookiematu.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.elvis.webbappcookiematu.models.Categoria;
import org.elvis.webbappcookiematu.services.CategoriaService;
import org.elvis.webbappcookiematu.services.CategoriaServiceJbdcImplement;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/categoria/form")
public class CategoriaFormControlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Traemos la conexion
        Connection conn=(Connection)req.getAttribute("conn");
        CategoriaService service=new CategoriaServiceJbdcImplement(conn);
        long id;
        //validamos el campo ingresado

        try{
            id=Long.parseLong(req.getParameter("id"));
        }catch (NumberFormatException e){
            id=0L;
        }
        Categoria categorias = new Categoria();
        if (id>0){
            //Creamos una variable de tipo optional para obtner la categoria por id
            Optional<Categoria>optionalCategoria=service.porId(id);
            //Si la variable esta presente obtenemos los datos
            if (optionalCategoria.isPresent()){
                categorias=optionalCategoria.get();
            }
        }
        //Seteamos los atributos
        req.setAttribute("categorias", categorias);
        getServletContext().getRequestDispatcher("/formularioCategoria.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn=(Connection)req.getAttribute("conn");
        CategoriaService service=new CategoriaServiceJbdcImplement(conn);
        String nombre=req.getParameter("nombre");
        String descripcion=req.getParameter("descripcion");

        //obtenemos el idCategoria
        Long id;
        try{
            id=Long.parseLong(req.getParameter("id"));

        }catch (NumberFormatException e){
            id=0L;
        }
        Categoria categorias = new Categoria();
        categorias.setIdCategoria(id);
        categorias.setNombre(nombre);
        categorias.setDescripcion(descripcion);

        // Mapa para errores
        Map<String, String> errores = new HashMap<>();

        if (nombre == null || nombre.trim().isEmpty()) {
            errores.put("nombre", "El nombre es obligatorio.");
        }

        if (descripcion == null || descripcion.trim().isEmpty()) {
            errores.put("descripcion", "La descripción es obligatoria.");
        }

        if (!errores.isEmpty()) {
            req.setAttribute("errores", errores);
            req.setAttribute("categorias", categorias);
            getServletContext().getRequestDispatcher("/formularioCategoria.jsp").forward(req, resp);
            return;
        }

        service.guardar(categorias);
        resp.sendRedirect(req.getContextPath()+"/categoria");
    }
}
