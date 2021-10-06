package com.mx.usuario.UsuarioControlador;

import com.mx.usuario.UsuarioBean.Usuario;
import com.mx.usuario.UsuarioService.UsuarioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/Usuario")
public class UsuarioControlador {

    @Autowired
    UsuarioServiceInterface usi;

    @PostMapping(value = "/registro")
    public ResponseEntity<Integer> registrarUsuario(@RequestBody Usuario usuario) {
        System.out.println("Entramos al metodo de registro");
        Integer registrarUsuario = usi.registrarUsuario(usuario);
        System.out.println("Consulta de resultado :" + registrarUsuario);
        if (registrarUsuario != 1) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(registrarUsuario);
    }


    @PostMapping(value = "/inicioSesion")
        public ResponseEntity<Integer> inicioSesion(@RequestBody Usuario usuario) {
        System.out.println("inicioSesion controlador");
        Integer valueInicioSesion = usi.inicioSesion(usuario);
        System.out.println("Consulta de resultado de inicioSesion :"+valueInicioSesion);
        if (valueInicioSesion != 5){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(valueInicioSesion);
    }


    @GetMapping(value = "/obtener")
    public ResponseEntity<List<Usuario>> obtenerUsuario(){
        List<Usuario> usuario = new ArrayList<>();
        System.out.println("Print obtener");


        usuario = usi.obtener();
        System.out.println("resultado :"+usuario);
        if (usuario == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuario);
    }


    @DeleteMapping(value = "/eliminar/{usuario}")
    public ResponseEntity<Integer> eliminarUsuario(@PathVariable("usuario") String usuario){
        System.out.println("Print in delete");
        Integer usuarioEliminado = usi.eliminar(usuario);
        if (usuarioEliminado != 1){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioEliminado);
    }


    @RequestMapping(value = "/actualizar/{Usuario}")
    public ResponseEntity<Integer> actualizarUsuario(@PathVariable("Usuario") String Usuario, @RequestBody Usuario usuario){
        usuario.setUsuario(Usuario);
        System.out.println("print in update");
        Integer usuarioActualizado = usi.actualizar(usuario);

        if (usuarioActualizado != 1) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioActualizado);
    }


}

