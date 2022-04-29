package com.lteste.loja.resources;

import com.lteste.loja.entidades.Venda;
import com.lteste.loja.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/vendas")
public class VendaResource {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public ResponseEntity<List<Venda>>findAll(){
        List<Venda>list=vendaService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<Venda>findById(@PathVariable Long id){
        Venda obj=vendaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
