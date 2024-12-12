package com.cibertec.dao;

import com.cibertec.models.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDao {

    //Unicamente usaremos esta intefaz para poder nombrar
    //el metodo que vamos a necesitar como lo es ObtenerUsuario
    //donde estableceremos dos parametros nombre y contrasena tipo String


//    List<Usuario> listarUsuarios() throws SQLException;
    Usuario obtenerUsuario (String nombre, String contrasena) throws SQLException;
//    void registrarUsuario(Usuario usuario) throws SQLException;


}
