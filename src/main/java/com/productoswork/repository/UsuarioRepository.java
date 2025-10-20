package com.productoswork.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productoswork.model.Usuario;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	  Optional<Usuario> findByDocumento(String documento);
	

}
