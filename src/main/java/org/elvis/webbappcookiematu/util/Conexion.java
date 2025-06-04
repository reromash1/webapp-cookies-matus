package org.elvis.webbappcookiematu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static String url = "jdbc:mysql://localhost:3306/trabajoenclase?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Aquí cargas el driver explícitamente
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("No se pudo cargar el driver de MySQL", e);
        }
        return DriverManager.getConnection(url, username, password);
    }
}
