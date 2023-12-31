package br.com.fiap.SneakerShop.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.SneakerShop.Model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Page<Produto> findByDescricaoContainingIgnoreCase(String descricao, Pageable pageRequest);
}