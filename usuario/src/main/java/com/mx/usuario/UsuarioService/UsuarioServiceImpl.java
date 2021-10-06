package com.mx.usuario.UsuarioService;

import com.mx.usuario.UsuarioBean.Usuario;
import com.mx.usuario.UsuarioDao.UsuarioDaoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioServiceInterface {


    @Autowired
    UsuarioDaoInterface udi;
    @Override
    public int registrarUsuario(Usuario usuario){
        System.out.println("Usuario registrado es service");
        return udi.registrarUsuario(usuario);
    }

    @Override
    public int inicioSesion(Usuario usuario) {

        return udi.inicioSesion(usuario);
    }

    @Override
    public List<Usuario> obtener() {
        return udi.obtener();
    }

    @Override
    public int eliminar(String usuario) { return udi.eliminar(usuario);}

    @Override
    public int actualizar(Usuario usuario) { return udi.actualizar(usuario);}


}
