package br.com.alura.forumAlura_API.service;

import br.com.alura.forumAlura_API.model.Usuario;
import br.com.alura.forumAlura_API.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

//    BCryptPasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();

    public Usuario cadastrar(Usuario usuario){
        //usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }
}
