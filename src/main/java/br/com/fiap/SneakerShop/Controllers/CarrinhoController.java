package br.com.fiap.SneakerShop.Controllers;

import br.com.fiap.SneakerShop.Model.Carrinho;
import br.com.fiap.SneakerShop.Model.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CarrinhoController {

    @GetMapping( "/carrinho" )
    public Carrinho index() {

        Produto produto = new Produto(5, "Air Max 95", BigDecimal.valueOf(900.00));

        return new Carrinho(2, produto);

    }

}
