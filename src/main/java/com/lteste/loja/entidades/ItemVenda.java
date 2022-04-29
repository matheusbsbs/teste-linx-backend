package com.lteste.loja.entidades;

import com.lteste.loja.pk.ItemVendaPk;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table (name="item_pedido")
public class ItemVenda implements Serializable {

    private static final long serialVersionUID=1L;

    @EmbeddedId
    private ItemVendaPk id =new ItemVendaPk();
    private Integer quantidade;
    private Number preco;
    public ItemVenda(){}

    public ItemVenda(Venda venda,Produto produto,Integer quantidade,Number preco){
        super();
        this.quantidade=quantidade;
        this.preco=preco;
        id.setVenda(venda);
        id.setProduto(produto);
    }

    public ItemVendaPk getId() {
        return id;
    }

    public void setId(ItemVendaPk id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Number getPreco() {
        return preco;
    }

    public void setPreco(Number preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemVenda)) return false;
        ItemVenda itemVenda = (ItemVenda) o;
        return getId().equals(itemVenda.getId()) && getQuantidade().equals(itemVenda.getQuantidade()) && getPreco().equals(itemVenda.getPreco());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getQuantidade(), getPreco());
    }
}

