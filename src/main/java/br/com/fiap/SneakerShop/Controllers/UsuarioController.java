package br.com.fiap.SneakerShop.Controllers;

import br.com.fiap.SneakerShop.Model.Carrinho;
import br.com.fiap.SneakerShop.Model.Favoritos;
import br.com.fiap.SneakerShop.Model.Produto;
import br.com.fiap.SneakerShop.Model.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class UsuarioController {

    @GetMapping( "/usuario" )
    public Usuario index() {

        Favoritos favoritos = new Favoritos(1, new Produto(2, "Air MAx Plus TN", BigDecimal.valueOf(1500.00)));
        Carrinho carrinho = new Carrinho(1, new Produto(3, "Vapor Max", BigDecimal.valueOf(1100.00)));

        return new Usuario(1, "Pedro Henrique", "rm97537@fiap.com.br", "020503", "02364-760", carrinho, favoritos);

    }

}
