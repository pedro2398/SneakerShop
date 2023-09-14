package br.com.fiap.SneakerShop.Controllers;

import br.com.fiap.SneakerShop.Model.Favoritos;
import br.com.fiap.SneakerShop.Repository.FavoritosRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.http.ResponseEntity;

@RestController
public class FavoritosController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    FavoritosRepository repository;

    @GetMapping( "/favoritos" )
    public List<Favoritos> getFavoritos() {
        log.info("mostrando todos os favoritos");
        
        return repository.findAll();
    }

    @PostMapping( "/favoritos" )
    public ResponseEntity<Favoritos> createFavoritos(@RequestBody Favoritos favorito) {
        log.info("cadastrando favorito - " + favorito);
        
        repository.save(favorito);

        return ResponseEntity.status(HttpStatus.CREATED).body(favorito);
    }

    @GetMapping( "/favoritos/{id}" )
    public ResponseEntity<Favoritos> getFavoritosId(@PathVariable Long id) {
        log.info("mostrando favorito do id " + id);
        
        return ResponseEntity.ok(getFavById(id));
    }

    @DeleteMapping( "favoritos/{id}" )
    public ResponseEntity<Object> deleteFavoritos(@PathVariable Long id) {
        log.info("deletando favorito com id" + id);
        
        getFavById(id);
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping( "favoritos/{id}" )
    public ResponseEntity<Favoritos> alterFavoritoResponseEntity(@PathVariable Long id, @RequestBody Favoritos newFavorito) {
        log.info("alterando favorito com id " + id);
        
        getFavById(id);
        newFavorito.setId(id);
        repository.save(newFavorito);

        return ResponseEntity.ok(newFavorito);
    }

    private Favoritos getFavById(Long id) {
        return repository.findById(id).orElseThrow( () -> {
            return new RuntimeException();
        } );
    }
}
