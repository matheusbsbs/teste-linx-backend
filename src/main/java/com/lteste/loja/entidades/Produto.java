package com.lteste.loja.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double custo;
    private Double preco;

    private Double margem;
    private String imagem;


    @OneToMany()
    private Set<ItemVenda> itensPedido=new HashSet<>();


    public Produto(){}

    public Produto(Long id,String nome, String descricao, Double custo, Double preco,String imagem, Double margem){
        super();
        this.id=id;
        this.nome=nome;
        this.descricao=descricao;
        this.custo=custo;
        this.preco=preco;
        this.margem=margem;
        this.imagem=imagem;
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Double getMargem() {
        return margem;
    }

    public void setMargem(Double margem) {
        this.margem = margem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return getId().equals(produto.getId()) && Objects.equals(getNome(), produto.getNome()) && Objects.equals(getDescricao(), produto.getDescricao()) && Objects.equals(getCusto(), produto.getCusto()) && Objects.equals(getPreco(), produto.getPreco()) && Objects.equals(getImagem(), produto.getImagem()) && Objects.equals(itensPedido, produto.itensPedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getDescricao(), getCusto(), getPreco(), getImagem(), itensPedido ,getMargem());
    }
}
