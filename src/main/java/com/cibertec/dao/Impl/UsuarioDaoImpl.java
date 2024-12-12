package com.cibertec.dao.Impl;

import com.cibertec.dao.UsuarioDao;
import com.cibertec.models.Usuario;
import com.cibertec.repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Extendemos de UsuarioDao para hacer uso de los metodos

public class UsuarioDaoImpl implements UsuarioDao {
//    @Override
//    public List<Usuario> listarUsuarios() throws SQLException {
//           List<Usuario> resultado = new ArrayList<>();
//           String query = "SELECT id ,nombre, contrasena FROM Usuarios";
//
//
//        try(
//                Connection connection = DBConnection.getConnection();
//                PreparedStatement statement = connection.prepareStatement(query);
//                ResultSet result = statement.executeQuery();
//        ) {
//
//            while (result.next()) {
//                Usuario itemUsuario = new Usuario(
//                        result.getInt("id"),
//                        result.getString("nombre"),
//                        result.getString("contrasena")
//                );
//                resultado.add(itemUsuario);
//            }
//        }
//        catch (ClassNotFoundException e){
//               throw  new RuntimeException(e);
//        }
//        return resultado;
//}

    //Aqui modificamos el metodo ObtenerUsuario para poder hacer la validacion
    //que luego sera enviado a el servlet ValidarSesionServlet

    @Override
    public Usuario obtenerUsuario(String nombre, String contrasena) throws SQLException {

        //Creamos una variable usuario del modelo Usuario pero que sea null
        Usuario usuario = null;

        //Almacenamos la consulta de SQL que queremos hacer
        String query = "SELECT id, nombre, contrasena FROM Usuarios WHERE nombre = ? AND contrasena = ?";

        try (
                //Realizamos la conexion para obtener los datos
                //lo establecemos como parametros para guardar recursos
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
        ) {
            //preparamos la consulta para los parametros nombre y contraseña
            statement.setString(1, nombre);
            statement.setString(2, contrasena);

            //Si lo que se ha ingresado existe o es valido;
            //Los datos se recuperaran de la base de datos
            //y se almacenaran en el objeto usuario vacio
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    usuario = new Usuario(
                            result.getInt("id"),
                            result.getString("nombre"),
                            result.getString("contrasena")
                    );
                }
            }
        }
        //Capturamos el error que pueda surgir en el codigo
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //retornamos el usuario con los valores recuperados
        //en caso no haya ningun error
        return usuario;
    }

//    @Override
//    public void registrarUsuario(Usuario usuario) throws SQLException {
//        String query = "INSERT INTO Usuarios (nombre, contrasena) VALUES (?, ?)";
//
//        try(
//                //establecemos la conexion momentanea
//                Connection connection = DBConnection.getConnection();
//                PreparedStatement statement = connection.prepareStatement(query);
//        ){
//
//            statement.setString(1, usuario.getNombre());
//            statement.setString(2, usuario.getContrasena());
//
//            //finalmento actualizamos la consulta
//            statement.executeUpdate();
//
//
//        }
//        //capturamos posibles errores que puedan suceder
//        catch (ClassNotFoundException e){
//            throw new RuntimeException(e);
//        }
//    }
}
