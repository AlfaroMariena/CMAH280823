
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empleados;
import modelo.EmpleadosDAL;



@WebServlet(name = "EmpleadosController", urlPatterns = {"/EmpleadosController"})
public class EmpleadosController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        EmpleadosDAL empleadosDAL = new EmpleadosDAL();
        String accion;
        RequestDispatcher dispatcher=null;
        
        accion=request.getParameter("accion");
        
        if(accion==null||accion.isEmpty()){
            dispatcher=request.getRequestDispatcher("vistas/index.jsp");
       
        List<Empleados>listaempleados =empleadosDAL.listarEmpleados();
         request.setAttribute("lista",listaempleados);
        
        }else if("nuevo".equals(accion)){
             dispatcher=request.getRequestDispatcher("vistas/nuevo.jsp");
             
        }else if("insertar".equals(accion)){
            
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            String gmail =request.getParameter("gmail");
            String puesto =request.getParameter("puesto");
            
            Empleados empleados  = new Empleados(0,nombre, apellido, gmail,puesto);
            
            empleadosDAL.insertar(empleados);

             dispatcher=request.getRequestDispatcher("vistas/index.jsp");
             List<Empleados>listaempleados =empleadosDAL.listarEmpleados();
             
         request.setAttribute("lista",listaempleados);
         
        }else if("modificar".equals(accion)){
             dispatcher=request.getRequestDispatcher("vistas/modificar.jsp");
             
              int id =Integer.parseInt(request.getParameter("id"));
              Empleados empleados =empleadosDAL.mostrarEmpleados(id);
              request.setAttribute("libros",empleados);
              
              
        }else if("actualizar".equals(accion)){
           int id =Integer.parseInt(request.getParameter("id"));
           
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            String gmail=request.getParameter("gmail");
            String puesto=request.getParameter("puesto");
            
            Empleados empleados  = new Empleados(id,nombre,apellido,gmail,puesto);
           empleadosDAL.actualizar(empleados);
             dispatcher=request.getRequestDispatcher("vistas/index.jsp");
             List<Empleados >listaempleados =empleadosDAL.listarEmpleados();
         request.setAttribute("lista",listaempleados);
        
         
         
        }else if("eliminar".equals(accion)){
          int id =Integer.parseInt(request.getParameter("id"));
           empleadosDAL.eliminar(id);
             dispatcher=request.getRequestDispatcher("vistas/index.jsp");
             List<Empleados>listaempleados =empleadosDAL.listarEmpleados();
         request.setAttribute("lista",listaempleados);
         
         
        } else {
            dispatcher=request.getRequestDispatcher("vistas/index.jsp");
             List<Empleados>listaempleados =empleadosDAL.listarEmpleados();
         request.setAttribute("lista",listaempleados);
        }
        dispatcher.forward(request,response);
     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
      
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
