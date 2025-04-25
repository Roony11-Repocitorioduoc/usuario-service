package com.chulitos.usuario_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chulitos.usuario_service.model.Usuario;
import com.chulitos.usuario_service.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController 
{
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listaUsuario()
    {
        List<Usuario> usuarios = usuarioService.getAll();

        if (usuarios.isEmpty())
            return ResponseEntity.noContent().build();
        
        return ResponseEntity.ok(usuarios);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") int id)
    {
        Usuario usuario = usuarioService.getUsuarioById(id);
        
        if (usuario == null)
            return ResponseEntity.noContent().build();
        
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario)
    {
        Usuario usuarioNuevo = usuarioService.save(usuario);
        
        return ResponseEntity.ok(usuarioNuevo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> eliminarUsuario(@PathVariable("id") int id)
    {
        Usuario usuarioBorrar = usuarioService.getUsuarioById(id);

        if (usuarioBorrar == null)
            return ResponseEntity.notFound().build();
        
        usuarioService.borrarUsuarioById(id);

        return ResponseEntity.noContent().build();
    }
}
