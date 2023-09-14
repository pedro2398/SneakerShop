package br.com.fiap.SneakerShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.SneakerShop.Model.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    
}
