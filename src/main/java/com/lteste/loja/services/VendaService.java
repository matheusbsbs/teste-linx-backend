package com.lteste.loja.services;

import com.lteste.loja.entidades.Venda;
import com.lteste.loja.repositorios.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda>findAll(){
            return vendaRepository.findAll();
    }

    public Venda findById(Long id){
        Optional<Venda> obj=vendaRepository.findById(id);
        return obj.get();
    }
}
