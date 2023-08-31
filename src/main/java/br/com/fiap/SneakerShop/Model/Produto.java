package br.com.fiap.SneakerShop.Model;

import java.math.BigDecimal;

public class Produto {
    private Long id;
    private String descricao;
    private BigDecimal preco;

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }


    public Produto() {
    }

    public Produto(String descricao, BigDecimal preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
