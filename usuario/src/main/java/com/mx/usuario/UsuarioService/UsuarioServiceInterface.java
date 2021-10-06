package com.mx.usuario.UsuarioService;

import com.mx.usuario.UsuarioBean.Usuario;

import java.util.List;

public interface UsuarioServiceInterface {

    public int registrarUsuario(Usuario usuario);

    int inicioSesion(Usuario usuario);

    public List<Usuario> obtener();

    public int eliminar(String usuario);

    int actualizar (Usuario usuario);
}
