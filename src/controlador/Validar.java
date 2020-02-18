package controlador;

import modelo.Empleado;
import modelo.EmpleadoDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Validar extends javax.servlet.http.HttpServlet {
    EmpleadoDAO edao = new EmpleadoDAO();
    Empleado em = new Empleado();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String accion = request.getParameter("accion");
        if(accion.equals("Ingresar")){
            String user = request.getParameter("txtuser");
            String pass = request.getParameter("txtpass");
            em = edao.validar(user,pass);
            if(em.getUser()!=null)
                request.getRequestDispatcher("Controlador?accion=Principal").forward(request,response);
            else
                request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        else{
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request,response);
    }
}
