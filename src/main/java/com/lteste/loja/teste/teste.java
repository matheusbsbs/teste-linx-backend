package com.lteste.loja.teste;

import com.lteste.loja.entidades.ItemVenda;
import com.lteste.loja.entidades.Produto;
import com.lteste.loja.entidades.Venda;
import com.lteste.loja.repositorios.ItemVendaRepository;
import com.lteste.loja.repositorios.ProdutoRepository;
import com.lteste.loja.repositorios.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class teste implements CommandLineRunner {

    @Autowired
   private ItemVendaRepository itemVendaRepository;

    @Autowired
   private ProdutoRepository produtoRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @Override
    public void run(String... args) throws Exception{
    Produto produto1 = new Produto(null, "Televisao","Televisao grande",null,null,null,null);
    Produto produto2 = new Produto(null, "Radio","Radio MP3",null,null,null,null);

        Venda venda1 = new Venda(null);
        Venda venda2 = new Venda(null);

       ItemVenda itemvenda1= new ItemVenda(venda1,produto1,2,20);
        ItemVenda itemvenda2= new ItemVenda(venda2,produto2,2,20);

        produtoRepository.saveAll(Arrays.asList(produto1, produto2));
        vendaRepository.saveAll(Arrays.asList(venda1, venda2));
      itemVendaRepository.saveAll(Arrays.asList(itemvenda1,itemvenda2));




    }



}
