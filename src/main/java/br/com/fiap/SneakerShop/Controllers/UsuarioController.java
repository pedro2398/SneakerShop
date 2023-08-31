package br.com.fiap.SneakerShop.Controllers;

import br.com.fiap.SneakerShop.Model.Usuario;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<Usuario> usuarios = new ArrayList<>();

    @GetMapping( "/usuario" )
    public List<Usuario> getUsuario() {
        log.info("mostrando todos os usuarios");

        return usuarios;
    }

    @PostMapping( "/usuario" )
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        log.info("cadastrando usuario - " + usuario);
        usuario.setId(usuarios.size() + 1L);
        usuarios.add(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping( "/usuario/{id}" )
    public ResponseEntity<Usuario> getUsuarioId(@PathVariable Long id) {
        log.info("mostrando usuario com id " + id);
        var usuarioEncontrado = usuarios
                                .stream()
                                .filter( (usuario) -> usuario.getId().equals(id) )
                                .findFirst();

        if(usuarioEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuarioEncontrado.get());
    }

    @DeleteMapping( "/usuario/{id}" )
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable Long id) {
        log.info("deletando usuario com o id " + id);
        var usuarioEncontrado = usuarios
                                .stream()
                                .filter( (usuario) -> usuario.getId().equals(id))
                                .findFirst();
        
        if(usuarioEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
                 
        usuarios.remove(usuarioEncontrado.get());

        return ResponseEntity.noContent().build();
    } 

    @PutMapping( "/usuario/{id}" )
    public ResponseEntity<Usuario> alterUsuario(@PathVariable Long id, @RequestBody Usuario newUsuario) {
        log.info("alterando usuario com id " + id);
        var usuarioEncontrado = usuarios
                                .stream()
                                .filter( (usuario) -> usuario.getId().equals(id) )
                                .findFirst();

        if(usuarioEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        usuarios.remove(usuarioEncontrado.get());
        newUsuario.setId(id);
        usuarios.add(newUsuario);

        return ResponseEntity.ok(newUsuario);
    }
}
