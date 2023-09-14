package br.com.fiap.SneakerShop.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Carrinho {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private long idProduto;

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

    public Carrinho() {
    }

    public Carrinho(Long id, long idProduto) {
        this.id = id;
        this.idProduto = idProduto;
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "id=" + id +
                ", idProduto=" + idProduto +
                '}';
    }
}
