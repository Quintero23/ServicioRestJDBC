package com.mx.usuario.UsuarioDao;

import com.mx.usuario.Conexion.DBUtil;
import com.mx.usuario.UsuarioBean.Usuario;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioDaoImpl implements UsuarioDaoInterface {


    @Override
    public int registrarUsuario(Usuario usuario){
        PreparedStatement ps;
        Connection conn;
        ResultSet rs;
        System.out.println("Entramos al dao :"+usuario.toString());
        try {
            conn = DBUtil.getConnection();
            conn.createStatement();
            String sqlRegistrar ="INSERT INTO USUARIO(usuario, password)VALUES(? , ?)";
            ps = conn.prepareStatement(sqlRegistrar);
            ps.setString( 1, usuario.getUsuario());
            ps.setString( 2, usuario.getPassword());
            rs = ps.executeQuery();
            if (rs.next()){
                return 1;
            }else{
                return 2;
            }

        }catch (SQLException e) {
            e.getErrorCode();
        }
        return 3;
    }


    @Override
    public int inicioSesion(Usuario usuario) {
        PreparedStatement pstmt;
        Connection con;
        ResultSet rs;


        System.out.println("usuario en dao :"+usuario.getUsuario());
        System.out.println("password en dao :"+usuario.getPassword());


        try {
            con = DBUtil.getConnection();
            con.createStatement();
            String sql="select * from USUARIO where usuario=?  and password=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString( 1, usuario.getUsuario());
            pstmt.setString( 2, usuario.getPassword());

            rs = pstmt.executeQuery();
            System.out.println(rs);
            if (rs.next()) {
                return 5;
            }else {
                return 6;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 7;
    }

    @Override
    public List<Usuario> obtener() {
        PreparedStatement pstmt;
        Connection conn;
        ResultSet rs;
        System.out.println("Entro a dao");
        List<Usuario> listData = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            conn.createStatement();
            String sql = "select usuario, password from USUARIO";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){

                listData.add(new Usuario(
                        rs.getString( "usuario"),
                        rs.getString( "password")
                )
                );
            }
        }catch (Exception ex){
        }
        System.out.println("Regresa"+listData);
        return listData;
    }

    @Override
    public int eliminar(String usuario){
        PreparedStatement pstmt;
        Connection conn;
        ResultSet rs;


        try {
            conn = DBUtil.getConnection();
            conn.createStatement();
            String sqlDelete = "DELETE FROM usuario WHERE Usuario = ?";
            pstmt = conn.prepareStatement(sqlDelete);
            pstmt.setString( 1, usuario);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return 1;
            }else {
                return 2;
            }

        }catch (Exception e){
        }
        return 0;
    }


    @Override
    public int actualizar(Usuario usuario) {
        PreparedStatement pstmt;
        Connection conn;
        ResultSet rs;

        try {
            conn = DBUtil.getConnection();
            conn.createStatement();
            String sqlUpdate = "UPDATE Usuario SET usuario =?, password =? WHERE Usuario =?";
            pstmt = conn.prepareStatement(sqlUpdate);
            pstmt.setString( 1, usuario.getUsuario());
            pstmt.setString(2, usuario.getPassword());
            pstmt.setString( 3, usuario.getUsuario());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return 1;
            }else {
                return 2;
            }

        }catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }


}
