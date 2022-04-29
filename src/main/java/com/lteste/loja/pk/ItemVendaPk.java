package com.lteste.loja.pk;

import com.lteste.loja.entidades.Produto;
import com.lteste.loja.entidades.Venda;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemVendaPk implements Serializable {

    private static final long serialVersionUID=1L;

    @ManyToOne
    @JoinColumn(name="id_venda")
    private Venda venda;

    @ManyToOne
    @JoinColumn(name="id_produto")
    private Produto produto;

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemVendaPk)) return false;
        ItemVendaPk that = (ItemVendaPk) o;
        return getVenda().equals(that.getVenda()) && getProduto().equals(that.getProduto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVenda(), getProduto());
    }
}
