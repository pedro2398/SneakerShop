package br.com.fiap.SneakerShop.Controllers;

import br.com.fiap.SneakerShop.Model.Carrinho;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CarrinhoController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<Carrinho> carrinhos = new ArrayList<>();

    @GetMapping( "/carrinho" )
    public List<Carrinho> getCarrinho() {
        log.info("mostrando todos os carrinhos");
        
        return carrinhos;
    }

    @PostMapping( "/carrinho" )
    public ResponseEntity<Carrinho> createCarrinho(@RequestBody Carrinho carrinho) {
        log.info("cadastrando carrinho - " + carrinho);
        carrinho.setId(carrinhos.size() + 1L);
        carrinhos.add(carrinho);

        return ResponseEntity.status(HttpStatus.CREATED).body(carrinho);
    }

    @GetMapping( "/carrinho/{id}" )
    public ResponseEntity<Carrinho> getCarrinhoId(@PathVariable Long id) {
        log.info("mostrando carrinho do id " + id);
        var carrinhoEncontrado = carrinhos
                                 .stream()
                                 .filter( (carrinho) -> carrinho.getId().equals(id) )
                                 .findFirst();
        
        if(carrinhoEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(carrinhoEncontrado.get());
    }

    @DeleteMapping( "carrinho/{id}" )
    public ResponseEntity<Object> deleteCarrinho(@PathVariable Long id) {
        log.info("deletando carrinho com id" + id);
        var carrinhoEncontrado = carrinhos
                                .stream()
                                .filter( (carrinho) -> carrinho.getId().equals(id))
                                .findFirst();

        if(carrinhoEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        carrinhos.remove(carrinhoEncontrado.get());

        return ResponseEntity.noContent().build();
    }

    @PutMapping( "carrinho/{id}" )
    public ResponseEntity<Carrinho> alterCarrinho(@PathVariable Long id, @RequestBody Carrinho newCarrinho) {
        log.info("alterando carrinho com id " + id);
        var carrinhoEncontrado = carrinhos
                                .stream()
                                .filter( (carrinho) -> carrinho.getId().equals(id))
                                .findFirst();

        if(carrinhoEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        carrinhos.remove(carrinhoEncontrado.get());
        newCarrinho.setId(id);

        return ResponseEntity.ok(newCarrinho);
    }
}
