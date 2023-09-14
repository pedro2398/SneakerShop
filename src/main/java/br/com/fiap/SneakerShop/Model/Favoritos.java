package br.com.fiap.SneakerShop.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Favoritos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idProduto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Favoritos() {
    }

    public Favoritos(Long id, Long idProduto) {
        this.id = id;
        this.idProduto = idProduto;
    }

    @Override
    public String toString() {
        return "Favoritos{" +
                "id=" + id +
                ", produto=" + idProduto +
                '}';
    }
}
