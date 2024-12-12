//package com.cibertec;
//
//import com.cibertec.dao.Impl.UsuarioDaoImpl;
//import com.cibertec.dao.UsuarioDao;
//import com.cibertec.models.Usuario;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//
//@WebServlet(name = "RegistroUsuarioServlet", urlPatterns = "/RegistroUsuarioServlet")
//public class RegistroUsuarioServlet extends HttpServlet {
//
//        UsuarioDao usuarioDao = new UsuarioDaoImpl();
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String nombre = req.getParameter("nombre");
//        String contrasena = req.getParameter("contrasena");
//
//        try {
//
//            if (nombre.isEmpty() || contrasena.isEmpty()) {
//                throw new Exception("los campos no deben ser vacias");
//            }
//
//            Usuario nuevoUsuario = new Usuario(
//                    0,nombre,contrasena
//            );
//
//            usuarioDao.registrarUsuario(nuevoUsuario);
//
//            resp.sendRedirect("RegistroUsuarioServlet");
//
//        } catch (Exception e) {
//            throw  new ServletException("No se pudo registrar",e);
//        }
//        }
//}
