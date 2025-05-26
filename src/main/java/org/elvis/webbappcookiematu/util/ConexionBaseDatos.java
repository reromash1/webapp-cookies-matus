package org.elvis.webbappcookiematu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    //declaramos e inicializamos las variables de conexión
    private static String url="jdbc:mysql://localhost:3306/compraventa?serverTimezone=UTC";
    private static String username="root";
    private static String password="";

    //Implementamos un método de tipo Connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
}
