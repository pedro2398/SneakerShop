package br.com.fiap.SneakerShop.Model;

public class Carrinho {
    private Long id;
    private Produto produto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Carrinho() {
    }

    public Carrinho(Long id, Produto produto) {
        this.id = id;
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "id=" + id +
                ", produto=" + produto +
                '}';
    }
}
