package modelo;
import config.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public Empleado validar(String user, String dni){
        Empleado em = new Empleado();
        String sql = "select * from empleado where empleado.User=? and empleado.Dni=?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs = ps.executeQuery();
            while(rs.next()){
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNombre(rs.getString("Nombres"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return em;
    }
}
