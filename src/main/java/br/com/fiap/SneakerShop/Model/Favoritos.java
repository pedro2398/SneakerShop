package br.com.fiap.SneakerShop.Model;

public class Favoritos {
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

    public Favoritos() {
    }

    public Favoritos(Long id, Produto produto) {
        this.id = id;
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Favoritos{" +
                "id=" + id +
                ", produto=" + produto +
                '}';
    }
}
