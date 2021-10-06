package com.mx.usuario.UsuarioDao;

import com.mx.usuario.UsuarioBean.Usuario;

import java.util.List;

public interface UsuarioDaoInterface {

    public int registrarUsuario(Usuario usuario);

    public int inicioSesion(Usuario usuario);

    public List<Usuario> obtener();

    public int eliminar(String usuario);

    int actualizar(Usuario usuario);

    }

