package br.com.fiap.SneakerShop.Controllers;

import br.com.fiap.SneakerShop.Model.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class ProdutoController {

    @GetMapping( "/produto" )
    public Produto index() {
        return new Produto(1, "Air Force 1", BigDecimal.valueOf(899.00));
    }

}
