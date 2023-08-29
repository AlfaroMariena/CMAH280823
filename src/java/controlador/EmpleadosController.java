
package controlador;

import java.io.IOException;
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
        String accion = request.getParameter("accion");
        RequestDispatcher dispatcher;

        if (accion == null || accion.isEmpty()) {
            List<Empleados> listaEmpleados = empleadosDAL.listarEmpleados();
            request.setAttribute("lista", listaEmpleados);
            dispatcher = request.getRequestDispatcher("vistas/index.jsp");
        } else if ("nuevo".equals(accion)) {
            dispatcher = request.getRequestDispatcher("vistas/nuevo.jsp");
            
        } else if ("insertar".equals(accion)) {
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String gmail = request.getParameter("gmail");
            String puesto = request.getParameter("puesto");

            Empleados empleados = new Empleados(0, nombre, apellido, gmail, puesto);
            empleadosDAL.insertar(empleados);

            List<Empleados> listaEmpleados = empleadosDAL.listarEmpleados();
            request.setAttribute("lista", listaEmpleados);
            dispatcher = request.getRequestDispatcher("vistas/index.jsp");
            
        } else if ("modificar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("id"));
            
            Empleados empleados = empleadosDAL.mostrarEmpleados(id);
            request.setAttribute("empleado", empleados);
            dispatcher = request.getRequestDispatcher("vistas/modificar.jsp");
            
        } else if ("actualizar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("id"));
            
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String gmail = request.getParameter("gmail");
            String puesto = request.getParameter("puesto");

            Empleados empleados = new Empleados(id, nombre, apellido, gmail, puesto);
            empleadosDAL.actualizar(empleados);

            List<Empleados> listaEmpleados = empleadosDAL.listarEmpleados();
            request.setAttribute("lista", listaEmpleados);
            dispatcher = request.getRequestDispatcher("vistas/index.jsp");
            
        } else if ("eliminar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("id"));
            empleadosDAL.eliminar(id);

            List<Empleados> listaEmpleados = empleadosDAL.listarEmpleados();
            request.setAttribute("lista", listaEmpleados);
            dispatcher = request.getRequestDispatcher("vistas/index.jsp");
        } else {
            List<Empleados> listaEmpleados = empleadosDAL.listarEmpleados();
            request.setAttribute("lista", listaEmpleados);
            dispatcher = request.getRequestDispatcher("vistas/index.jsp");
        }

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Empleados Controller";
    }
}
