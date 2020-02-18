package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection con;
    String url = "jdbc:mysql://localhost:3306/bd_ventas", user = "root", pass = "";
    public Connection Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user , pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

}
