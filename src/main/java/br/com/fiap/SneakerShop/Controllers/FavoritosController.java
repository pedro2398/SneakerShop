package br.com.fiap.SneakerShop.Controllers;

import br.com.fiap.SneakerShop.Model.Favoritos;
import br.com.fiap.SneakerShop.Model.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class FavoritosController {

    @GetMapping( "/favoritos" )
    public Favoritos index() {

        Produto produto = new Produto(4, "Nike Dunk", BigDecimal.valueOf(1100.00));

        return new Favoritos(2, produto);

    }

}
