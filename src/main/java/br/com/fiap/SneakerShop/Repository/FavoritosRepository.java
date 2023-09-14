package br.com.fiap.SneakerShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.SneakerShop.Model.Favoritos;

public interface FavoritosRepository extends JpaRepository<Favoritos, Long> {
    
}
