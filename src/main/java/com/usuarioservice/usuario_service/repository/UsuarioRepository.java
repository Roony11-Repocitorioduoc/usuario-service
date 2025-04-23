package com.usuarioservice.usuario_service.repository;

import com.usuarioservice.usuario_service.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>
{
    
}
