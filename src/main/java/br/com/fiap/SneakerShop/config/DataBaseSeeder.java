package br.com.fiap.SneakerShop.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.SneakerShop.Model.Produto;
import br.com.fiap.SneakerShop.Repository.ProdutoRepository;

@Configuration
public class DataBaseSeeder implements CommandLineRunner {

    @Autowired
    ProdutoRepository produtoRepository;

    private Produto airMax = new Produto(null, "Air Max Plus TN", BigDecimal.valueOf(1300.00));
    private Produto airForce = new Produto(null, "Air Force One", BigDecimal.valueOf(800.00));
    private Produto vaporMax = new Produto(null, "Vapor Max", BigDecimal.valueOf(1100.00));
    private Produto nikeDunk = new Produto(null, "Nike Dunk", BigDecimal.valueOf(900.00));
    private Produto nikeShox = new Produto(null, "Nike Shox", BigDecimal.valueOf(800.00));
    private Produto airJordan3 = new Produto(null, "Air Jordan 3", BigDecimal.valueOf(1700.00));

    @Override
    public void run(String... args) throws Exception {

        produtoRepository.saveAll(
                List.of(airForce, vaporMax, airMax, nikeDunk, nikeShox, airJordan3));
    }

}