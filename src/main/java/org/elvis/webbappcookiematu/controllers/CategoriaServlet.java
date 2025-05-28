package org.elvis.webbappcookiematu.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.elvis.webbappcookiematu.models.Categoria;
import org.elvis.webbappcookiematu.services.CategoriaService;
import org.elvis.webbappcookiematu.services.CategoriaServiceJdbcImplement;
import org.elvis.webbappcookiematu.services.LoginService;
import org.elvis.webbappcookiematu.services.LoginServiceSessionImplement;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@WebServlet("/categorias")
public class CategoriaServlet extends HttpServlet {

    //Creamos la conexión a la BBDD


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Creamos la conexión
        Connection conn = (Connection) req.getAttribute("conn");
        //Creamos el nuevocategorias objeto
        CategoriaService service = new CategoriaServiceJdbcImplement(conn);
        //Creamos la lista
        List<Categoria> categorias = service.listar();
        //Obtenmos los parametros de la sesion

        LoginService auth = new LoginServiceSessionImplement();
        Optional<String> userNameOptional = auth.getUserName(req);

        //Seteamos los atributos de categoria y el username
        req.setAttribute("categorias", categorias );
        req.setAttribute("username", userNameOptional);

        //Redireccionamos a la vista de listarCategoria.jsp
        getServletContext().getRequestDispatcher("/listarCategoria.jsp").forward(req, resp);
    }
}
