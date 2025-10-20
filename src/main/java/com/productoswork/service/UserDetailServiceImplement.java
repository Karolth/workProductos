package com.productoswork.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import com.productoswork.model.Usuario;

@Service
public class UserDetailServiceImplement implements UserDetailsService {

    @Autowired
    private IUsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String documento) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOpt = usuarioService.findByDocumento(documento);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            return User.builder()
                .username(usuario.getDocumento())
                .password(usuario.getPassword())
         
                .build();
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
    }
}
