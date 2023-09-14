package br.com.fiap.SneakerShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.SneakerShop.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
