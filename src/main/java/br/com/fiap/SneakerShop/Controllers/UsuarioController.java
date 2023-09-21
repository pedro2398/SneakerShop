package br.com.fiap.SneakerShop.Controllers;

import br.com.fiap.SneakerShop.Model.Usuario;
import br.com.fiap.SneakerShop.Repository.UsuarioRepository;
import jakarta.validation.Valid;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    UsuarioRepository repository;

    @GetMapping( "/usuario" )
    public List<Usuario> getUsuario() {
        log.info("mostrando todos os usuarios");
        
        return repository.findAll();
    }

    @PostMapping( "/usuario" )
    public ResponseEntity<Usuario> createUsuario(@RequestBody @Valid Usuario usuario) {
        log.info("cadastrando usuario - " + usuario);
       
        repository.save(usuario);
       
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping( "/usuario/{id}" )
    public ResponseEntity<Usuario> getUsuarioId(@PathVariable Long id) {
        log.info("mostrando usuario com id " + id);
        
        return ResponseEntity.ok(getUsuarioById(id));
    }

    @DeleteMapping( "/usuario/{id}" )
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable Long id) {
        log.info("deletando usuario com o id " + id);
        
        getUsuarioById(id);
        repository.deleteById(id);;
        
        return ResponseEntity.noContent().build();
    } 

    @PutMapping( "/usuario/{id}" )
    public ResponseEntity<Usuario> alterUsuario(@PathVariable Long id, @RequestBody @Valid Usuario newUsuario) {
        log.info("alterando usuario com id " + id);

        getUsuarioById(id);
        newUsuario.setId(id);
        repository.save(newUsuario);

        return ResponseEntity.ok(newUsuario);
    }

    private Usuario getUsuarioById(Long id) {
        return repository.findById(id).orElseThrow( () -> {
            return new RuntimeException();
        } );
    }
}
