package br.com.fiap.SneakerShop.Controllers;

import br.com.fiap.SneakerShop.Model.Produto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.SneakerShop.Repository.ProdutoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ProdutoRepository repository;


    @GetMapping
    public Page<Produto> getProduto(
     @PageableDefault(size = 3, sort = "id") Pageable pageRequest,
     @RequestParam String descricao
     ){

        log.info("mostrando todos os produtos");

        if (descricao == null || descricao.isEmpty()){
            return repository.findAll(pageRequest);
        }

        return repository.findByDescricaoContainingIgnoreCase(descricao, pageRequest);
    }

    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody @Valid Produto produto) {
        log.info("casdastrando Produto - " + produto);
        
        repository.save(produto);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping( "{id}" )
    public ResponseEntity<Produto> getProdutoId(@PathVariable Long id) {
        log.info("mostrar produto com id " + id);
        
        return ResponseEntity.ok(getProdById(id));
    }

    @DeleteMapping( "{id}" )
    public ResponseEntity<Object> deleteProduto(@PathVariable Long id) {
        log.info("excluindo produto com id " + id);
        
        getProdById(id);
        repository.deleteById(id);
        
        return ResponseEntity.noContent().build();   
    }

    @PutMapping( "{id}" )
    public ResponseEntity<Produto> alterProduto(@PathVariable Long id, @RequestBody @Valid Produto newProduto) {
        log.info("alterando produto com id " + id);
        
        getProdById(id);
        newProduto.setId(id);
        repository.save(newProduto);

        return ResponseEntity.ok(newProduto);
    }

    private Produto getProdById(Long id) {
        return repository.findById(id).orElseThrow( () -> {
            return new RuntimeException();
        } );
    }
}