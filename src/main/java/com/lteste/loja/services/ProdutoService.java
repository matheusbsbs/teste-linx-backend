package com.lteste.loja.services;

import com.lteste.loja.entidades.Produto;
import com.lteste.loja.exceptions.DataExeption;
import com.lteste.loja.exceptions.ResourceException;
import com.lteste.loja.repositorios.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {


    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) {
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.get();
    }

    public Produto update(Long id, Produto obj) {
        try {
            Produto entity = produtoRepository.getOne(id);
            updateData(entity, obj);
            return produtoRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceException(id);
        }
    }

    public Produto insert(Produto obj) {
        return produtoRepository.save(obj);
    }
    private void updateData(Produto entity, Produto obj) {
        entity.setNome(obj.getNome());
        entity.setDescricao(obj.getDescricao());
        entity.setCusto(obj.getCusto());
        entity.setPreco(obj.getPreco());
        entity.setImagem(obj.getImagem());
        entity.setMargem(obj.getMargem());
    }
    public void delete(Long id) {
        try {
            produtoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataExeption(e.getMessage());
        }
    }
    public double somaPrecoDeVenda() {
        List<Produto> produtoList = produtoRepository.findAll();
        double margemLucro = 10;
        double somaPrecoVenda = 0;
        double atualizaPrecoVenda = 0;
        for (Produto list : produtoList) {
            somaPrecoVenda = list.getCusto() + somaCustoDeCompra();
            atualizaPrecoVenda = somaPrecoVenda * (1 + (margemLucro) / 100);
        }
        return atualizaPrecoVenda;
    }
    public double somaCustoDeCompra() {
        List<Produto> produtoList = produtoRepository.findAll();
        long quantidadeDeProduto = 0;
        double despesasTotais = 0;
        double rateioDespesas = 0;
        for (Produto list : produtoList) {
            despesasTotais = despesasTotais + list.getPreco();
        }
        return rateioDespesas = despesasTotais / quantidadeDeProduto;
    }



}
