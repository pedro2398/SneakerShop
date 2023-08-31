package br.com.fiap.SneakerShop.Controllers;

import br.com.fiap.SneakerShop.Model.Produto;

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
public class ProdutoController {

    Logger log = LoggerFactory.getLogger(getClass());

    List<Produto> produtos = new ArrayList<>();

    @GetMapping( "/produto" )
    public List<Produto> getProduto() {
        log.info("mostrando todos os produtos");
        return produtos;
    }

    @PostMapping( "/produto" )
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto) {
        log.info("casdastrando Produto - " + produto);
        produto.setId(produtos.size() + 1L);
        produtos.add(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping( "/produto/{id}" )
    public ResponseEntity<Produto> getProdutoId(@PathVariable Long id) {
        log.info("mostrar produto com id " + id);
        var prodEncontrado = produtos
                                    .stream()
                                    .filter( (produto) -> produto.getId().equals(id))
                                    .findFirst();

        if(prodEncontrado.isEmpty()) {
           return ResponseEntity.notFound().build(); 
        } 
        
        return ResponseEntity.ok(prodEncontrado.get());
    }

    @DeleteMapping( "/produto/{id}" )
    public ResponseEntity<Object> deleteProduto(@PathVariable Long id) {
        log.info("excluindo produto com id " + id);
        var prodEncontrado = produtos
                                    .stream()
                                     .filter( (produto) -> produto.getId().equals(id) )
                                     .findFirst();

        if(prodEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        } 
        
        produtos.remove(prodEncontrado.get());

        return ResponseEntity.noContent().build();   
    }

    @PutMapping( "/produto/{id}" )
    public ResponseEntity<Produto> alterProduto(@PathVariable Long id, @RequestBody Produto newProduto) {
        log.info("alterando produto com id " + id);
        var prodEncontrado = produtos
                             .stream()
                             .filter( (produto) -> produto.getId().equals(id) )
                             .findFirst();

        produtos.remove(prodEncontrado.get());
        newProduto.setId(id);
        produtos.add(newProduto);

        if (prodEncontrado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(newProduto);
    }
}