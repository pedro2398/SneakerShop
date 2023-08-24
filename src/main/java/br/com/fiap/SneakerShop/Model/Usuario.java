package br.com.fiap.SneakerShop.Model;

public class Usuario {
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private String Endereco;
    private Carrinho carrinho;
    private Favoritos favoritos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Favoritos getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(Favoritos favoritos) {
        this.favoritos = favoritos;
    }

    public Usuario() {
    }

    public Usuario(Integer id, String nome, String email, String senha, String endereco, Carrinho carrinho, Favoritos favoritos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        Endereco = endereco;
        this.carrinho = carrinho;
        this.favoritos = favoritos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", Endereco='" + Endereco + '\'' +
                ", carrinho=" + carrinho +
                ", favoritos=" + favoritos +
                '}';
    }
}
