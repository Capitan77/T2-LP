package com.cibertec;

import com.cibertec.dao.Impl.UsuarioDaoImpl;
import com.cibertec.dao.UsuarioDao;
import com.cibertec.models.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "ValidarSesionServlet", urlPatterns = "/ValidarSesionServlet")
public class ValidarSesionServlet extends HttpServlet {


    //Creamos una variable llamada usuarioDao que pertenezca al Dao para poder hacer uso de la
    // implementacion de el metodo que necesitamos
    UsuarioDao usuarioDao = new UsuarioDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Almacenamos nombres y contraseñas en variables tipo String para validarlas
        String nombre = req.getParameter("nombre");
        String contrasena = req.getParameter("contrasena");

        try {

            //Dentro del try comenzamos llamando al metodo ObtenerUsuario colocando
            //como parametro el nombre y contraseña que hemos recuperado y transformado a cadena
            Usuario usuario = usuarioDao.obtenerUsuario(nombre, contrasena);


            //si el usuario que hemos validado es diferente de nul entonces

            // obtenemos los nombres y contraseñas atraves de get y lo enviamos
            //por medio de una varible
            //todo esto ira directamente hacia validacion.jsp
            if (usuario != null) {
                req.setAttribute("nombre", usuario.getNombre());
                req.setAttribute("contrasena", usuario.getContrasena());
                req.getRequestDispatcher("Validacion.jsp").forward(req, resp);
            } else {
                //en caso se encuentre un error ; nos enviaran un mensaje atraves de
                //el parametro error
                //y esto sera redirigido hacia formulario.jsp
                req.setAttribute("error", "Usuario o contraseña incorrectos");
                req.getRequestDispatcher("formulario.jsp").forward(req, resp);
            }
        } catch (SQLException e) {

            //aqui capturamos un eror en caso el codigo falle
            throw new RuntimeException(e);
        }
    }
}
