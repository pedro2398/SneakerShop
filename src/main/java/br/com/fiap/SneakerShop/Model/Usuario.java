package br.com.fiap.SneakerShop.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    private String endereco;

    private Long idCarrinho;

    private long idFavoritos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return endereco;
    }

    public void setEndereco(String endereco) {
       this.endereco = endereco;
    }

    public Long getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(Long idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    public Long getIdFavoritos() {
        return idFavoritos;
    }

    public void setIdFavoritos(long idFavoritos) {
        this.idFavoritos = idFavoritos;
    }

    public Usuario() {
    }

    public Usuario(Long id, String nome, String email, String senha, String endereco, Long idCarrinho, Long idFavoritos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
        this.idCarrinho = idCarrinho;
        this.idFavoritos = idFavoritos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", Endereco='" + endereco + '\'' +
                ", carrinho=" + idCarrinho +
                ", favoritos=" + idFavoritos +
                '}';
    }
}
