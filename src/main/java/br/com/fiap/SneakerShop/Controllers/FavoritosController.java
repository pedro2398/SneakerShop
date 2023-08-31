package br.com.fiap.SneakerShop.Controllers;

import br.com.fiap.SneakerShop.Model.Favoritos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
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

    List<Favoritos> favoritos = new ArrayList<>();

    @GetMapping( "/favoritos" )
    public List<Favoritos> getFavoritos() {
        log.info("mostrando todos os favoritos");
        
        return favoritos;
    }

    @PostMapping( "/favoritos" )
    public ResponseEntity<Favoritos> createFavoritos(@RequestBody Favoritos favorito) {
        log.info("cadastrando favorito - " + favorito);
        favorito.setId(favoritos.size() + 1L);
        favoritos.add(favorito);

        return ResponseEntity.status(HttpStatus.CREATED).body(favorito);
    }

    @GetMapping( "/favoritos/{id}" )
    public ResponseEntity<Favoritos> getFavoritosId(@PathVariable Long id) {
        log.info("mostrando favorito do id " + id);
        var favoritoEncontrado = favoritos
                                 .stream()
                                 .filter( (favorito) -> favorito.getId().equals(id) )
                                 .findFirst();
        
        if(favoritoEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(favoritoEncontrado.get());
    }

    @DeleteMapping( "favoritos/{id}" )
    public ResponseEntity<Object> deleteFavoritos(@PathVariable Long id) {
        log.info("deletando favorito com id" + id);
        var favoritoEncontrado = favoritos
                                .stream()
                                .filter( (favorito) -> favorito.getId().equals(id))
                                .findFirst();

        if(favoritoEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        favoritos.remove(favoritoEncontrado.get());

        return ResponseEntity.noContent().build();
    }

    @PutMapping( "favoritos/{id}" )
    public ResponseEntity<Favoritos> alterFavoritoResponseEntity(@PathVariable Long id, @RequestBody Favoritos newFavorito) {
        log.info("alterando favorito com id " + id);
        var favoritoEncontrado = favoritos
                                 .stream()
                                 .filter( (favorito) -> favorito.getId().equals(id) )
                                 .findFirst();

        if(favoritoEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        favoritos.remove(favoritoEncontrado.get());
        newFavorito.setId(id);
        favoritos.add(newFavorito);

        return ResponseEntity.ok(newFavorito);
    }
}
