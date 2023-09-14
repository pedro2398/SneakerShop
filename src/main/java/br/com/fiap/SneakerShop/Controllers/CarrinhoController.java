package br.com.fiap.SneakerShop.Controllers;

import br.com.fiap.SneakerShop.Model.Carrinho;
import br.com.fiap.SneakerShop.Repository.CarrinhoRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    CarrinhoRepository repository;

    @GetMapping( "/carrinho" )
    public List<Carrinho> getCarrinho() {
        log.info("mostrando todos os carrinhos");
        
        return repository.findAll();
    }

    @PostMapping( "/carrinho" )
    public ResponseEntity<Carrinho> createCarrinho(@RequestBody Carrinho carrinho) {
        log.info("cadastrando carrinho - " + carrinho);
        
        repository.save(carrinho);

        return ResponseEntity.status(HttpStatus.CREATED).body(carrinho);
    }

    @GetMapping( "/carrinho/{id}" )
    public ResponseEntity<Carrinho> getCarrinhoId(@PathVariable Long id) {
        log.info("mostrando carrinho do id " + id);
        
        return ResponseEntity.ok(getCarById(id));
    }

    @DeleteMapping( "carrinho/{id}" )
    public ResponseEntity<Object> deleteCarrinho(@PathVariable Long id) {
        log.info("deletando carrinho com id" + id);
        
        getCarById(id);
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping( "carrinho/{id}" )
    public ResponseEntity<Carrinho> alterCarrinho(@PathVariable Long id, @RequestBody Carrinho newCarrinho) {
        log.info("alterando carrinho com id " + id);
        
        getCarById(id);
        newCarrinho.setId(id);
        repository.save(newCarrinho);

        return ResponseEntity.ok(newCarrinho);
    }

    private Carrinho getCarById(Long id) {
        return repository.findById(id).orElseThrow( () -> {
            return new RuntimeException();
        } );
    }
    
}
