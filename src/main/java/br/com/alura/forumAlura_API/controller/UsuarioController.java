package br.com.alura.forumAlura_API.controller;

import br.com.alura.forumAlura_API.model.Usuario;
import br.com.alura.forumAlura_API.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;


    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario, UriComponentsBuilder uriComponentsBuilder){
        return new ResponseEntity<Usuario>(usuarioService.cadastrar(usuario), HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Usuario>> findAll(){
        return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
    }
}
