package com.productoswork.service;


import java.util.Optional;

import com.productoswork.model.Usuario;

public interface IUsuarioService {

	
	    Optional<Usuario> findByDocumento(String documento);
	    Usuario save(Usuario usuario);
	


}
